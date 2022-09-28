package com.example.tilultimatemain.domain.user.service;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder encoder;

    @Transactional
    public void execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getEmail());

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(encoder.encode(request.getPassword()))
                        .sex(request.getSex())
                        .build());
    }
}
