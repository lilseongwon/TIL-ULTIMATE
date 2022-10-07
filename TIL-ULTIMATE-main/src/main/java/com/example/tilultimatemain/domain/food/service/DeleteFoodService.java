package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFoodService {
    private final FoodRepository foodRepository;
    private final FoodFacade foodFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        userFacade.checkPermission();
        Food food = foodFacade.getFoodById(id);
        foodRepository.delete(food);
    }
}
