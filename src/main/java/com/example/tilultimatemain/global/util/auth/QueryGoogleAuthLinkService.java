package com.example.tilultimatemain.global.util.auth;

import com.example.tilultimatemain.global.security.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryGoogleAuthLinkService {

    private static final String url = "%s?client_id=%s&redirect_uri=%s&response_type=code"
            + "&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

    private final AuthProperties authProperties;

    public String execute() {
        return String.format(url, //이 형식으로 아래 것들을 짜준다 ~
                authProperties.getBaseUrl(),
                authProperties.getClientId(),
                authProperties.getRedirectUrl());
    }
}