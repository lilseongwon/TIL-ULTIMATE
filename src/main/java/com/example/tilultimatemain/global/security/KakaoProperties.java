package com.example.tilultimatemain.global.security;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("auth.kakao")
public class KakaoProperties {

    private final String baseUrl;
    private final String clientId;
    private final String redirectUrl;
    private final String clientSecret;


    public KakaoProperties(String baseUrl, String clientId, String clientSecret, String redirectUrl) {
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }
}
