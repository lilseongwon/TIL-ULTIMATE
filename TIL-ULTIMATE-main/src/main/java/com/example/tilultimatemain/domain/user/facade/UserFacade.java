package com.example.tilultimatemain.domain.user.facade;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public void checkUserExist(String accountId) {
        Optional<User> user = userRepository.findByAccountId(accountId);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }
}
