package com.example.tilultimatemain.domain.user.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdatePwRequest {
    private String password;
    private String newPassword;
}
