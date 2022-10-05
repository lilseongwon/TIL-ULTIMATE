package com.example.tilultimatemain.domain.food.facade;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.exception.FoodExistException;
import com.example.tilultimatemain.domain.food.exception.FoodNotFoundException;
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

    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> FoodNotFoundException.EXCEPTION);
    }
}
