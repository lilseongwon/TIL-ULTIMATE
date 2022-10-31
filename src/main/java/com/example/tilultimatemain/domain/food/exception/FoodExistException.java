package com.example.tilultimatemain.domain.food.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class FoodExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new FoodExistException();

    private FoodExistException() {
        super(ErrorCode.ALREADY_FOOD_EXIST);
    }
}
