package com.cloudnative.grokking.mercury.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * @author nghiatn
 */

@Aspect
@Slf4j
public class MessageControllerAspect {
    @Before("execution(String com.cloudnative.grokking.mercury.controller.rpc.MessageController.ping(String))")
    public void before(JoinPoint joinPoint) {
        //Advice
        log.info("MessageControllerAspect");
        log.info(" Allowed execution for {}", joinPoint);
    }


    @AfterReturning(value = "execution(String com.cloudnative.grokking.mercury.controller.rpc.MessageController.ping(String))", returning = "result")
    public void afterReturn(JoinPoint joinPoint, String result) {
        //Advice
        log.info("MessageControllerAspect");

        log.info("MessageControllerAspect: " + result.toString());
        log.info(" Allowed execution for {}", joinPoint);
    }

}
