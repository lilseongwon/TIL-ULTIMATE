package com.example.tilultimatemain.domain.user.presentation;

import com.example.tilultimatemain.domain.auth.presentation.response.TokenResponse;
import com.example.tilultimatemain.domain.user.presentation.request.UserSigninRequest;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import com.example.tilultimatemain.domain.user.service.UserSigninService;
import com.example.tilultimatemain.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;

    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }

}
