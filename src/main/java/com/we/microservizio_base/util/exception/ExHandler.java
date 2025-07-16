package com.we.microservizio_base.util.exception;

import com.we.microservizio_base.util.ExResponse;
import com.we.microservizio_base.util.MapperUtil;
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

        ExResponse exResponse = (ex instanceof NotFoundEx)
                ? mapperUtil.fromExToExResponse((NotFoundEx) ex)
                : mapperUtil.fromExToExResponse(ex);

        return new ResponseEntity<>(exResponse, HttpStatusCode.valueOf(exResponse.getStatusCode()));
    }
}
