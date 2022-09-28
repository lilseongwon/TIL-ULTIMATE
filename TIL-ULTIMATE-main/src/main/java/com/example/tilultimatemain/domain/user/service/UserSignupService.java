package com.example.tilultimatemain.domain.user.service;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import com.example.tilultimatemain.domain.user.presentation.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getAccountId());

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .sex(request.getSex())
                        .build());
    }
}
