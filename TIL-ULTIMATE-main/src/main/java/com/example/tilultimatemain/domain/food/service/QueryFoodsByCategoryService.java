package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Category;
import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodListResponse;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryFoodsByCategoryService {
    private final FoodRepository foodRepository;

    @Transactional
    public QueryFoodListResponse execute(Category category) {
        List<QueryFoodResponse> foodResponseList = foodRepository.findAllByCategoryContains(category)
                .stream()
                .map(QueryFoodResponse::of).toList();
        return new QueryFoodListResponse(foodResponseList);
    }
}
