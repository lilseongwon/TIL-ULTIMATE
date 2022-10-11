package com.example.tilultimatemain.domain.order.service;

import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.presentation.response.QueryOrderListResponse;
import com.example.tilultimatemain.domain.order.presentation.response.QueryOrderResponse;
import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryMyOrderService {
    private final UserFacade userFacade;
    private final OrderRepository orderRepository;

    public QueryOrderListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<QueryOrderResponse> orderResponseList = orderRepository.findAllByUserId(user)
                .stream()
                .map(QueryOrderResponse::of).toList();
        return new QueryOrderListResponse(orderResponseList);
    }
}