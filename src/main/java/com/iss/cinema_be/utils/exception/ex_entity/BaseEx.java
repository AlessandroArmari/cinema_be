package com.iss.cinema_be.utils.exception.ex_entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEx extends RuntimeException {

    private String message;
    private String javaMessage;
    private Integer statusCode;
    private LocalDateTime timeStamp;
    private String classWhere;
    private String fileName;
    private String method;
    private String lineNumber;
    private String endPoint;


    public BaseEx() {
        super();
        this.statusCode = 500;
        this.timeStamp = LocalDateTime.now();

        StackTraceElement[] stackTraceElements = this.getStackTrace();

        //this.classWhere = stackTraceElements[0].getClassName();
        this.method = stackTraceElements[0].getMethodName();
        this.lineNumber = String.valueOf(stackTraceElements[0].getLineNumber());
        this.fileName = stackTraceElements[0].getFileName();
        this.endPoint = "endPoint";

    }
}
