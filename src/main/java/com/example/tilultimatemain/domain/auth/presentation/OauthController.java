package com.example.tilultimatemain.domain.auth.presentation;

import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.domain.auth.service.KakaoAuthService;
import com.example.tilultimatemain.global.util.auth.QueryGoogleAuthLinkService;
import com.example.tilultimatemain.global.util.auth.QueryKakaoAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OauthController {
    private final KakaoAuthService kakaoAuthService;
    private final QueryKakaoAuthLinkService queryKakaoAuthLinkService;

    @GetMapping("/kakao/auth")
    public String queryKakaoAuthLink() {
        return queryKakaoAuthLinkService.execute();
    }

    @GetMapping("/kakao/receiveCode")
    public TokenResponse kakaoAuthLogin(@RequestParam("code") String code) {
        return kakaoAuthService.execute(code);
    }
}
