package com.we.microservizio_base.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExResponse {

    private String message;
    private Integer statusCode;
    private LocalDateTime timestamp;

}
