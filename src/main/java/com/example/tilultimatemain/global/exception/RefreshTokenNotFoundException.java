package com.example.tilultimatemain.global.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class RefreshTokenNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}