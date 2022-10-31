package com.example.tilultimatemain.infrastructure.feign.exception;


import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class OtherBadRequestException extends CustomException {

    public static final CustomException EXCEPTION =
            new OtherBadRequestException();

    private OtherBadRequestException() {
        super(ErrorCode.OTHER_BAD_REQUEST);
    }
}