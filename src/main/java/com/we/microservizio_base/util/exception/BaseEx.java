package com.we.microservizio_base.util.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEx extends RuntimeException {

    private String message;
    private Integer statusCode;
    private LocalDateTime timestamp;

    public BaseEx(String message) {
        super(message);
        this.message = message;
        this.statusCode = 500;
        this.timestamp = LocalDateTime.now();
    }
}
