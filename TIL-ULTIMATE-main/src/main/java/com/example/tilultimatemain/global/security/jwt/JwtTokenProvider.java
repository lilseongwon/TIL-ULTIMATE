package com.example.tilultimatemain.global.security.jwt;

import com.example.tilultimatemain.domain.auth.domain.RefreshToken;
import com.example.tilultimatemain.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.global.exception.ExpiredJwtException;
import com.example.tilultimatemain.global.exception.InvalidJwtException;
import com.example.tilultimatemain.global.exception.SignatureJwtException;
import com.example.tilultimatemain.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    public TokenResponse generateTokens(String accountId) {
        String accessToken = generateToken(accountId, ACCESS_KEY, jwtProperties.getAccessExp());
        String refreshToken = generateToken(accountId, REFRESH_KEY, jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .ttl(jwtProperties.getRefreshExp())
                .build());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.ES256, jwtProperties.getSecret())
                .setSubject(accountId)
                .setHeaderParam("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }
}

