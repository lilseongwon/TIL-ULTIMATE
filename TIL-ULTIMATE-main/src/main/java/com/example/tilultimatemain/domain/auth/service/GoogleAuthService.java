package com.example.tilultimatemain.domain.auth.service;

import com.example.tilultimatemain.domain.auth.domain.RefreshToken;
import com.example.tilultimatemain.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.global.security.AuthProperties;
import com.example.tilultimatemain.global.security.jwt.JwtProperties;
import com.example.tilultimatemain.global.security.jwt.JwtTokenProvider;
import com.example.tilultimatemain.infrastructure.feign.client.GoogleAuth;
import com.example.tilultimatemain.infrastructure.feign.client.GoogleInfo;
import com.example.tilultimatemain.infrastructure.feign.dto.request.GoogleCodeRequest;
import com.example.tilultimatemain.infrastructure.feign.dto.response.GoogleInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Service
public class GoogleAuthService {

    private final GoogleAuth googleAuth;
    private final GoogleInfo googleInfo;
    private final AuthProperties authProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponse execute(String code) {

        String accessToken = googleAuth.googleAuth(
                GoogleCodeRequest.builder()
                        .code(URLDecoder.decode(code, StandardCharsets.UTF_8))
                        .clientId(authProperties.getClientId())
                        .clientSecret(authProperties.getClientSecret())
                        .redirectUri(authProperties.getRedirectUrl())
                        .build()
        ).getAccessToken();

        GoogleInfoResponse googleInfoResponse = googleInfo.googleInfo(accessToken);

        String email = googleInfoResponse.getEmail();
        String name = googleInfoResponse.getName();

        String refreshToken =jwtTokenProvider.generateRefreshToken(email);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(email)
                        .token(refreshToken)
                        .ttl(jwtProperties.getRefreshExp() * 1000)
                        .build()
        );
        createUser(email, name);

        return TokenResponse
                .builder()
                .accessToken(jwtTokenProvider.generateAccessToken(email))
                .refreshToken(refreshToken)
                .build();
    }

    private void createUser(String email, String name) {
        if (userRepository.findByEmail(email).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .email(email)
                            .name(name)
                            .build());
        }
    }
}