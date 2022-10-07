package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodListResponse;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryFoodListService {
    private final FoodRepository foodRepository;

    @Transactional
    public QueryFoodListResponse execute() {
        List<QueryFoodResponse> foodResponseList = foodRepository.findAllByOrderByIdDesc()
                .stream()
                .map(QueryFoodResponse::of).toList();
        return new QueryFoodListResponse(foodResponseList);
    }
}
