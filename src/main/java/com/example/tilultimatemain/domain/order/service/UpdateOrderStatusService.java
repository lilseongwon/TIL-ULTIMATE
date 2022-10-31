package com.example.tilultimatemain.domain.order.service;

import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.facade.OrderFacade;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateOrderStatusService {
    private final UserFacade userFacade;
    private final OrderFacade orderFacade;
    private final OrderRepository orderRepository;

    public void execute(Long id) {
        userFacade.checkPermission();
        Order order = orderFacade.getOrderById(id);
        order.completeCook();
        orderRepository.save(order);
    }
}