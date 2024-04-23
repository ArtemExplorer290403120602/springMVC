package com.home.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {
    @AfterThrowing(pointcut = "execution(* com.home.service.*.*(..))", throwing = "exception")
    public void handleServiceException(JoinPoint joinPoint, Exception exception) {
        System.out.println("Exception occurred in service method: " + joinPoint.getSignature().getName() + ". Exception: " + exception.getMessage());
    }
}
