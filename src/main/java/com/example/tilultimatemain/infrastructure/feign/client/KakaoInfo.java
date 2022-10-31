package com.example.tilultimatemain.infrastructure.feign.client;

import com.example.tilultimatemain.infrastructure.feign.dto.response.KakaoInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GoogleInfoClient", url = "https://kapi.kakao.com/v2/user/me")
public interface KakaoInfo {
    @GetMapping("?alt=json&access_token={ACCESS_TOKEN}")
    KakaoInfoResponse kakaoInfo(@PathVariable("ACCESS_TOKEN") String accessToken);
}
