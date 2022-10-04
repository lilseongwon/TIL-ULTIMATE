package com.example.tilultimatemain.domain.user.service;

import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import com.example.tilultimatemain.domain.user.presentation.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyinfoService {

    private final UserFacade userFacade;

    @Transactional
    public QueryUserInfoResponse execute() {

        User user = userFacade.getCurrentUser();

        return QueryUserInfoResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .money(user.getMoney())
                .build();
    }
}
