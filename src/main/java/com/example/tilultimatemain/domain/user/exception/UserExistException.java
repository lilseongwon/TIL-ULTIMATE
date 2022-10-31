package com.example.tilultimatemain.domain.user.exception;

import com.example.tilultimatemain.global.error.CustomException;
import com.example.tilultimatemain.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
