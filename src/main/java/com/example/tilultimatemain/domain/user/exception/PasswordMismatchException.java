package com.example.tilultimatemain.domain.user.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
