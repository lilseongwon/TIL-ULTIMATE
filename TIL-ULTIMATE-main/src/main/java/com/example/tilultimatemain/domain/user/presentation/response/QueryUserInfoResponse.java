package com.example.tilultimatemain.domain.user.presentation.response;

import com.example.tilultimatemain.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final String email;
    private final String name;

    public static QueryUserInfoResponse of(User user) {
        return QueryUserInfoResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
