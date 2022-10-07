package com.example.tilultimatemain.domain.order.facade;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderFacade {
    private final FoodFacade foodFacade;

    public Integer getPrice(Long id, Integer sum) {
        Food food = foodFacade.getFoodById(id);
        return food.getPrice() * sum;
    }
}
