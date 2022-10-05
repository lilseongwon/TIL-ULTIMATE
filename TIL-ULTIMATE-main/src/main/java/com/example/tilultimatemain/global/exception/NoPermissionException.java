package com.example.tilultimatemain.global.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class NoPermissionException extends CustomException {
    public static final CustomException EXCEPTION =
            new NoPermissionException();

    private NoPermissionException() {
        super(ErrorCode.NO_PERMISSION);
    }
}
