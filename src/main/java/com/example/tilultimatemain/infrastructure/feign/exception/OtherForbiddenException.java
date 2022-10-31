package com.example.tilultimatemain.infrastructure.feign.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class OtherForbiddenException extends CustomException {

    public static final CustomException EXCEPTION =
            new OtherForbiddenException();

    private OtherForbiddenException() {
        super(ErrorCode.OTHER_FORBIDDEN);
    }

}