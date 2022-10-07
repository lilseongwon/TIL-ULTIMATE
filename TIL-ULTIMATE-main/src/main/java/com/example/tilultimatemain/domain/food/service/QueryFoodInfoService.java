package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryFoodInfoService {
    private final FoodFacade foodFacade;

    @Transactional
    public QueryFoodInfoResponse execute(Long id) {
        Food food = foodFacade.getFoodById(id);

        return QueryFoodInfoResponse.builder()
                .name(food.getName())
                .category(food.getCategory())
                .explain(food.getExplain())
                .picture(food.getPicture())
                .build();
    }
}
