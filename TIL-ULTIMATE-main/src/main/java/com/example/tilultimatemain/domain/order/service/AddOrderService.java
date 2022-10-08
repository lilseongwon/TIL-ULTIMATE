package com.example.tilultimatemain.domain.order.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.repository.OrderRepository;
import com.example.tilultimatemain.domain.order.facade.OrderFacade;
import com.example.tilultimatemain.domain.order.presentation.request.AddOrderRequest;
import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddOrderService {
    private final OrderRepository orderRepository;
    private final UserFacade userFacade;
    private final FoodFacade foodFacade;
    private final OrderFacade orderFacade;

    public void execute(Long id, AddOrderRequest request) {
        User user = userFacade.getCurrentUser();
        Food food = foodFacade.getFoodById(id);

        orderRepository.save(Order
                .builder()
                .foodId(food)
                .userId(user)
                .sum(request.getSum())
                .price(orderFacade.getPrice(id, request.getSum()))
                .build());
    }
}
