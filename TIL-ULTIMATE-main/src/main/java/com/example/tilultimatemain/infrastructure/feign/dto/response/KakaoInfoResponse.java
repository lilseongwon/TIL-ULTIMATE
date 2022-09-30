package com.example.tilultimatemain.infrastructure.feign.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoInfoResponse {
    private String email;
    private String name;
}