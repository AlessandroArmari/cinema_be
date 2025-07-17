package com.we.microservizio_base.utils.exception.ex_entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEx extends RuntimeException {

    private String message;
    private String javaMessage;
    private Integer statusCode;
    private LocalDateTime timestamp;
    private String classWhere;
    private String methodWhere;
    private String lineNumberWhere;
    private String fileNameWhere;


    public BaseEx() {
        super();
        this.message = message;
        this.statusCode = 500;
        this.timestamp = LocalDateTime.now();

        StackTraceElement[] stackTraceElements = this.getStackTrace();

        this.classWhere = stackTraceElements[0].getClassName();
        this.methodWhere = stackTraceElements[0].getMethodName();
        this.lineNumberWhere = stackTraceElements[0].getFileName();
        this.fileNameWhere = stackTraceElements[0].getFileName();

    }
}
