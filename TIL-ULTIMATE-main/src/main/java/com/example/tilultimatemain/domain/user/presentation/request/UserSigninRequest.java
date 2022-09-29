package com.example.tilultimatemain.domain.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSigninRequest {
    private String email;
    private String password;
}
