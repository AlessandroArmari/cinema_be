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
    private Integer statusCode;
    private LocalDateTime timestamp;
    private String classWhere;
    private String methodWhere;
    private String lineNumberWhere;
    private String fileNameWhere;


}
