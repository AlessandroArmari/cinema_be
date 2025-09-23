package com.iss.cinema_be.utils.logger;

import com.iss.cinema_be.utils.exception.ExResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class BaseLogger {

    public static void info(String message) {

        patternModifier("INFO", message);

        log.info(message);
    }

    public static void error(String message, ExResponse exResponse) {

        MDC.put("statusCode", exResponse.getStatusCode());
        MDC.put("timeStamp", exResponse.getTimeStamp().toString());
        MDC.put("fileName", exResponse.getFileName());
        MDC.put("method", exResponse.getMethod());
        MDC.put("lineNumber", exResponse.getLineNumber());
        MDC.put("endPoint", exResponse.getEndPoint());

        //quando e se siavrò uno user
        //MDC.put("userId", "UserIdDaDefinire");
        log.error(message);

    }

    private static void patternModifier(String className, String method) {


        MDC.put("className", className);
        MDC.put("method", method);
        //MDC.put("endPoint", getEndPoint());

        //MDC.put("userId", "UserIdDaDefinire");

    }

}
