package com.we.microservizio_base.utils.exception;

import com.we.microservizio_base.utils.MapperUtil;
import com.we.microservizio_base.utils.exception.ex_entity.BaseEx;
import com.we.microservizio_base.utils.exception.ex_entity.NotFoundEx;
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


        return new ResponseEntity<>(exResponse, HttpStatusCode.valueOf(exResponse.getStatusCode()));
    }
}
