package com.example.customer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(public * com.example.customer.controller.CustomerController.*(..))",throwing = "e")
    public void logAfterMethodReturn(JoinPoint joinPoint, Exception e) {
        String nameMethod = joinPoint.getSignature().getName();
//        System.out.println(nameMethod);
        logger.error("Name method: " + nameMethod + ". Error: "  + e.getMessage());
    }
}
