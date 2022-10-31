package com.example.tilultimatemain.infrastructure.feign.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class OtherExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new OtherExpiredTokenException();

    private OtherExpiredTokenException() {
        super(ErrorCode.OTHER_EXPIRED_TOKEN);
    }

}