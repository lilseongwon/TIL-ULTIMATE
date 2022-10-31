package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateFoodService {
    private final UserFacade userFacade;
    private final FoodFacade foodFacade;

    public void execute(Long id, FoodRequest request) {
        userFacade.checkPermission();
        Food food = foodFacade.getFoodById(id);
        food.updateFood(request.getName(), request.getCategory(),
                request.getExplain(), request.getPicture(), request.getPrice());
    }
}
