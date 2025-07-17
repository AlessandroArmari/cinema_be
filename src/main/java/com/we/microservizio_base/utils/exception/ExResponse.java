package com.we.microservizio_base.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExResponse {

    private String message;
    private String javaMessage;
    private String statusCode;
    private LocalDateTime timeStamp;
    private String method;
    private String lineNumber;
    private String fileName;
    private String endPoint;


}
