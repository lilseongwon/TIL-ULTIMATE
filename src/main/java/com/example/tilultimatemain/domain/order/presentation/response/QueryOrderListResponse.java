package com.example.tilultimatemain.domain.order.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryOrderListResponse {
    private final List<QueryOrderResponse> orderResponseList;
}
