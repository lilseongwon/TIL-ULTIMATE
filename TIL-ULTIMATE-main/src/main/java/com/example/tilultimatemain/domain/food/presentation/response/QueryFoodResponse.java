package com.example.tilultimatemain.domain.food.presentation.response;

import com.example.tilultimatemain.domain.food.domain.Category;
import com.example.tilultimatemain.domain.food.domain.Food;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryFoodResponse {
    private final String name;
    private final Category category;
    private final String picture;
    private final Integer price;

    public static QueryFoodResponse of(Food food) {
        return QueryFoodResponse.builder()
                .name(food.getName())
                .category(food.getCategory())
                .picture(food.getPicture())
                .price(food.getPrice())
                .build();
    }
}
