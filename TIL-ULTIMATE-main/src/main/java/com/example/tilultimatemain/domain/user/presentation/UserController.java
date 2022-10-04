package com.example.tilultimatemain.domain.user.presentation;

import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.domain.user.presentation.request.UserSigninRequest;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import com.example.tilultimatemain.domain.user.presentation.request.UserUpdatePwRequest;
import com.example.tilultimatemain.domain.user.service.UserSigninService;
import com.example.tilultimatemain.domain.user.service.UserSignupService;
import com.example.tilultimatemain.domain.user.service.UserUpdatePwService;
import com.example.tilultimatemain.domain.user.service.WithdrawlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;
    private final UserUpdatePwService userUpdatePwService;
    private final WithdrawlService withdrawlService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePw(@RequestBody UserUpdatePwRequest request) {
        userUpdatePwService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/")
    public void withdrawl() {
        withdrawlService.execute();
    }
}
