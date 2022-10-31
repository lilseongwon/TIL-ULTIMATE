package com.example.tilultimatemain.global.facade;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
