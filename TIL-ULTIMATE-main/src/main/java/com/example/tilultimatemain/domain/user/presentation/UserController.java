package com.example.tilultimatemain.domain.user.presentation;

import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.domain.user.presentation.request.UserSigninRequest;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import com.example.tilultimatemain.domain.user.presentation.request.UserUpdatePwRequest;
import com.example.tilultimatemain.domain.user.presentation.response.QueryUserInfoResponse;
import com.example.tilultimatemain.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;
    private final UserUpdatePwService userUpdatePwService;
    private final WithdrawlService withdrawlService;
    private final LogoutService logoutService;
    private final TokenRefreshService tokenRefreshService;
    private final QueryMyinfoService queryMyinfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse signIn(@RequestBody @Valid  UserSigninRequest request) {
        return userSigninService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePw(@RequestBody @Valid UserUpdatePwRequest request) {
        userUpdatePwService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/")
    public void withdrawl() {
        withdrawlService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }

    @PatchMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("X-Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @GetMapping("/")
    public QueryUserInfoResponse queryMyInfo() {
        return queryMyinfoService.execute();
    }
}
