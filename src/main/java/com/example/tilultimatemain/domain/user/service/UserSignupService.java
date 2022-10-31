package com.example.tilultimatemain.domain.user.service;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.exception.UserExistException;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void execute(UserSignupRequest request) {
        checkUserExist(request.getEmail());

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(encoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build());
    }

    private void checkUserExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }
}
