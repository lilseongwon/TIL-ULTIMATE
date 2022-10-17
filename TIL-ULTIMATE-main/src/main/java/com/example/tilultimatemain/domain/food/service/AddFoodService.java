package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.exception.FoodExistException;
import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddFoodService {
    private final FoodRepository foodRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(FoodRequest request) {
        userFacade.checkPermission();
        checkFoodExist(request.getName());

        foodRepository.save(
                Food.builder()
                        .name(request.getName())
                        .category(request.getCategory())
                        .explain(request.getExplain())
                        .picture(request.getPicture())
                        .price(request.getPrice())
                        .build());
    }

    private void checkFoodExist(String name) {
        if(foodRepository.findByName(name).isPresent())
            throw FoodExistException.EXCEPTION;
    }
}
