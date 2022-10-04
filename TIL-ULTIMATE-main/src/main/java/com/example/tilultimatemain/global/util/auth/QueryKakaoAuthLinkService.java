package com.example.tilultimatemain.global.util.auth;

import com.example.tilultimatemain.global.security.AuthProperties;
import com.example.tilultimatemain.global.security.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryKakaoAuthLinkService {
    private static final String url = "%s?client_id=%s&redirect_uri=%s&response_type=code"
            + "&scope=account_email, profile_nickname";
    private final KakaoProperties kakaoProperties;

    public String execute() {
        return String.format(url,
                kakaoProperties.getBaseUrl(),
                kakaoProperties.getClientId(),
                kakaoProperties.getRedirectUrl());
    }
}
