package com.we.microservizio_base.utils.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Slf4j
public class BaseLogger {

    public static void info(String message) {

        patternModifier("INFO", message);

        log.info(message);
    }

    public static void error(String message) {

        log.error(message);
    }

    private static void patternModifier(String className, String method) {


        MDC.put("className", className);
        MDC.put("method", method);
        //MDC.put("endPoint", getEndPoint());

        //MDC.put("userId", "UserIdDaDefinire");

    }

}
