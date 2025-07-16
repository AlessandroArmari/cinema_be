package com.we.microservizio_base.util.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEx extends RuntimeException {

    private String message;

    public BaseEx(String message) {
        super(message);
        this.message = message;
    }
}
