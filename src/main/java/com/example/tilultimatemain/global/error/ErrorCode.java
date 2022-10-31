package com.example.tilultimatemain.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),
    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    NO_PERMISSION(401, "No Permission"),

    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    USER_NOT_FOUND(404, "User Not Found"),
    FOOD_NOT_FOUND(404, "Food Not Found"),
    ORDER_NOT_FOUND(404, "Order Not Found"),


    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    USER_EXIST(409, "User Exist"),

    ALREADY_FOOD_EXIST(409, "Already Food Exist"),


    OTHER_BAD_REQUEST(400, "Other server bad request"),
    OTHER_UNAUTHORIZED(401, "Other server unauthorized"),
    OTHER_FORBIDDEN(403, "Other server forbidden"),
    OTHER_EXPIRED_TOKEN(419, "Other server expired token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private final int status;
    private final String message;
}