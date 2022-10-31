package com.example.tilultimatemain.domain.order.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class OrderNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new OrderNotFoundException();

    private OrderNotFoundException() {
        super(ErrorCode.ORDER_NOT_FOUND);
    }
}
