package com.example.tilultimatemain.domain.order.facade;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderFacade {
    private final FoodFacade foodFacade;
    private final OrderRepository orderRepository;

    public Integer getPrice(Long id, Integer sum) {
        Food food = foodFacade.getFoodById(id);
        return food.getPrice() * sum;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> OrderNotFoundException.EXCEPTION);
    }
}
