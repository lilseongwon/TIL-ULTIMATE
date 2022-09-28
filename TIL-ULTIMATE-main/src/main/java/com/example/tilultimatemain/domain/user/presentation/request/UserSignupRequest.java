package com.example.tilultimatemain.domain.user.presentation.request;

import com.example.tilultimatemain.domain.user.domain.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignupRequest {

    @NotBlank(message = "name은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String accountId;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$", message = "password는 8-30자여야합니다.")
    private String password;

    private Sex sex;
}
