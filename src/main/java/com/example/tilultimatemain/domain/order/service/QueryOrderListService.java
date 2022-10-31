package com.example.tilultimatemain.domain.order.service;

import com.example.tilultimatemain.domain.order.domain.Status;
import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.presentation.response.QueryOrderListResponse;
import com.example.tilultimatemain.domain.order.presentation.response.QueryOrderResponse;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryOrderListService {
    private final UserFacade userFacade;
    private final OrderRepository orderRepository;

    @Transactional
    public QueryOrderListResponse execute() {
        userFacade.checkPermission();
        List<QueryOrderResponse> orderResponseList = orderRepository.findAllByStatus(Status.COOK)
                .stream()
                .map(QueryOrderResponse::of).toList();
        return new QueryOrderListResponse(orderResponseList);
    }
}