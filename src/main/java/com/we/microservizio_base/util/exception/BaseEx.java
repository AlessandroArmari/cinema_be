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
    private String javaMessage;
    private Integer statusCode;
    private LocalDateTime timestamp;
    private String classWhere;
    private String methodWhere;
    private String lineNumberWhere;
    private String fileNameWhere;


    public BaseEx(String message) {
        super();
        this.message = message;
        //this.javaMessage = this.getCause().getMessage();
        this.statusCode = 500;
        this.timestamp = LocalDateTime.now();

        StackTraceElement[] stackTraceElements = this.getStackTrace();

        this.classWhere = stackTraceElements[0].getClassName();
        this.methodWhere = stackTraceElements[0].getMethodName();
        this.lineNumberWhere = stackTraceElements[0].getFileName();
        this.fileNameWhere = stackTraceElements[0].getFileName();

    }
}
