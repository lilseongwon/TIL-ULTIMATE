package com.example.tilultimatemain.domain.user.presentation.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final String email;
    private final String name;
}
