package com.example.tilultimatemain.domain.food.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryFoodListResponse {
    private final List<QueryFoodResponse> foodResponseList;
}
