package com.example.tilultimatemain.domain.order.facade;

import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderFacade {
    private final OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> OrderNotFoundException.EXCEPTION);
    }
}