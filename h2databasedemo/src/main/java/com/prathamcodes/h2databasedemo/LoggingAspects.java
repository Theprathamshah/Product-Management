package com.prathamcodes.h2databasedemo;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspects {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.prathamcodes.h2databasedemo..*.*(..))")
    private void restControllerMethods() {}

    @Before("restControllerMethods()")
    public void beforeMethodExecution() {
        logger.info("Before method execution");
    }
    @After("restControllerMethods()")
    public void afterMethodExecution() {
        logger.info("After method execution");
    }

    @AfterReturning(pointcut = "restControllerMethods()", returning = "result")
    public void afterMethodExecution(Object result) {
        logger.info("Method execution finished with result: {}", result);
    }
}
