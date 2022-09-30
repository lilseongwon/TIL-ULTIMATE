package com.example.tilultimatemain.global.util.auth;

import com.example.tilultimatemain.global.security.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryKakaoAuthLinkService {
    private static final String url = "%s?client_id=%s&redirect_uri=%s&response_type=code"
            + "&scope=account_email, account_name";
    private final AuthProperties authProperties;

    public String execute() {
        return String.format(url,
                authProperties.getBaseUrl(),
                authProperties.getClientId(),
                authProperties.getRedirectUrl());
    }
}
