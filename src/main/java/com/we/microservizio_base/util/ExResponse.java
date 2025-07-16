package com.we.microservizio_base.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExResponse {

    public String message;
    public Integer statusCode;
    public LocalDateTime timestamp;

}
