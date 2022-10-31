package com.example.tilultimatemain.infrastructure.feign;

import com.example.tilultimatemain.infrastructure.feign.exception.OtherBadRequestException;
import com.example.tilultimatemain.infrastructure.feign.exception.OtherExpiredTokenException;
import com.example.tilultimatemain.infrastructure.feign.exception.OtherForbiddenException;
import com.example.tilultimatemain.infrastructure.feign.exception.OtherUnAuthorizedException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) throws FeignException {

        if(response.status() >= 400) {
            switch (response.status()){
                case 401:
                    throw OtherUnAuthorizedException.EXCEPTION;
                case 403:
                    throw OtherForbiddenException.EXCEPTION;
                case 419:
                    throw OtherExpiredTokenException.EXCEPTION;
                default:
                    throw OtherBadRequestException.EXCEPTION;
            }
        }

        return FeignException.errorStatus(methodKey, response);
    }

}