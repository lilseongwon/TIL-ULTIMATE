package com.example.tilultimatemain.infrastructure.feign.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoCodeRequest {
    private final String code;
    private final String clientId;
    private final String redirectUri;
    private final String clientSecret;
    private final String grantType = "authorization_code";

    @Builder
    public KakaoCodeRequest(String code, String clientId, String clientSecret, String redirectUri) {
        this.code = code;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }
}
