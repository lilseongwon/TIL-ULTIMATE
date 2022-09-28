package com.example.tilultimatemain.domain.user.facade;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.exception.UserExistException;
import com.example.tilultimatemain.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public void checkUserExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }

    public User getUserByAccountId(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
