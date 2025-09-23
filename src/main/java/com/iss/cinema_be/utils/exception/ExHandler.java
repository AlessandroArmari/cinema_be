package com.iss.cinema_be.utils.exception;

import com.iss.cinema_be.utils.MapperUtil;
import com.iss.cinema_be.utils.exception.ex_entity.BaseEx;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;
import com.iss.cinema_be.utils.logger.BaseLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RequiredArgsConstructor
public class ExHandler extends ResponseEntityExceptionHandler {

    private final MapperUtil mapperUtil;

    @ExceptionHandler(BaseEx.class)
    public ResponseEntity<ExResponse> BaseExHandler(BaseEx ex) {

        ExResponse exResponse = switch (ex) {
            case NotFoundEx nf -> mapperUtil.fromExToExResponse(nf);
            default -> mapperUtil.fromExToExResponse(ex);
        };

        BaseLogger.error(exResponse.getMessage(), exResponse);

        return new ResponseEntity<>(exResponse, HttpStatusCode.valueOf(Integer.parseInt(exResponse.getStatusCode())));
    }
}
