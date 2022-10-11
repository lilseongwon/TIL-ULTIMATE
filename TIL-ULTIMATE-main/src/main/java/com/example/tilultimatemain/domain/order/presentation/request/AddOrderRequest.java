package com.example.tilultimatemain.domain.order.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AddOrderRequest {

    @NotNull(message = "sum은 Null을 허용하지 않습니다")
    private Integer sum;
}
