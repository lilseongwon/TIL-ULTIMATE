package com.example.tilultimatemain.domain.food.facade;

import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.exception.FoodExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FoodFacade {
    private final FoodRepository foodRepository;

    public void checkFoodExist(String name) {
        if(foodRepository.findByName(name).isPresent())
            throw FoodExistException.EXCEPTION;
    }
}
