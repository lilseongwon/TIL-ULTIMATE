package com.example.tilultimatemain.infrastructure.feign.client;

import com.example.tilultimatemain.infrastructure.feign.dto.request.KakaoCodeRequest;
import com.example.tilultimatemain.infrastructure.feign.dto.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "KakaoAuthClient", url = "https://kauth.kakao.com/oauth/token")
public interface KakaoAuth {
    @PostMapping
    TokenResponse kakaoAuth(KakaoCodeRequest kakaoCodeRequest);
}