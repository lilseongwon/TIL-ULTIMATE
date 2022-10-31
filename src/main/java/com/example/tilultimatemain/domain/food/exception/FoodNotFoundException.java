package com.example.tilultimatemain.domain.food.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class FoodNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new FoodNotFoundException();

    private FoodNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }
}
