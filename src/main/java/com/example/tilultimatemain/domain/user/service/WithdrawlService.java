package com.example.tilultimatemain.domain.user.service;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.domain.repository.UserRepository;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WithdrawlService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
    }
}
