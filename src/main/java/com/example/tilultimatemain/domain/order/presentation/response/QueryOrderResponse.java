package com.example.tilultimatemain.domain.order.presentation.response;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodResponse;
import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.Status;
import com.example.tilultimatemain.domain.user.presentation.response.QueryUserInfoResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class QueryOrderResponse {
    private final Long id;
    private final QueryFoodResponse food;
    private final QueryUserInfoResponse user;
    private final LocalDate createdAt;
    private final Status status;
    private Integer sum;
    private Integer price;


    public static QueryOrderResponse of(Order order) {
        return QueryOrderResponse.builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .food(QueryFoodResponse.of(order.getFood()))
                .user(QueryUserInfoResponse.of(order.getUser()))
                .status(order.getStatus())
                .sum(order.getSum())
                .price(order.getPrice())
                .build();
    }
}
