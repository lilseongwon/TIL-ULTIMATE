package com.example.tilultimatemain.domain.food.presentation.response;

import com.example.tilultimatemain.domain.food.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class QueryFoodInfoResponse {
    private final String name;
    private final Category category;
    private final String explain;
    private final String picture;
    private final Integer price;
}
