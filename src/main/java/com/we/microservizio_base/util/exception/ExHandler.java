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

    /*
    @ExceptionHandler(NotFoundEx.class)
    public ResponseEntity<ExResponse> NotFoundExHandler(NotFoundEx ex) {
        return new ResponseEntity<>(mapperUtil.fromExToExResponse(ex), HttpStatusCode.valueOf(ex.getStatusCode()));
    }

     */

    @ExceptionHandler(BaseEx.class)
    public ResponseEntity<ExResponse> BaseExHandler(BaseEx ex) {
            return new ResponseEntity<>(mapperUtil.fromExToExResponse(ex), HttpStatusCode.valueOf(ex.getStatusCode()));

    }
}
