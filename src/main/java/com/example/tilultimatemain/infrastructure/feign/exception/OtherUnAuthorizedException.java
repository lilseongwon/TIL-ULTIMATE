package com.example.tilultimatemain.infrastructure.feign.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class OtherUnAuthorizedException extends CustomException {

    public static final CustomException EXCEPTION =
            new OtherUnAuthorizedException();

    private OtherUnAuthorizedException() {

        super(ErrorCode.OTHER_UNAUTHORIZED);
    }

}