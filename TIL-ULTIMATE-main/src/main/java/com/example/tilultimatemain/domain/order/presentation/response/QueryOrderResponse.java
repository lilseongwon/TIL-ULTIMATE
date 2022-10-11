package com.example.tilultimatemain.domain.order.presentation.response;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.Status;
import com.example.tilultimatemain.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class QueryOrderResponse {
    private final Food food;
    private final User user;
    private final LocalDate createdAt;
    private final Status status;

    public static QueryOrderResponse of(Order order) {
        return QueryOrderResponse.builder()
                .createdAt(order.getCreatedAt())
                .food(order.getFood())
                .user(order.getUser())
                .status(order.getStatus()).build();
    }
}
