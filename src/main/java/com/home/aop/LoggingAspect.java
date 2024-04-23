package com.home.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.home.service.*.*(..))")
    public void beforeServiceMethodExecution(JoinPoint joinPoint) {
        System.out.println("Before execution of service method: " + joinPoint.getSignature().getName());
    }
    //TODO: @Before - совет, который выполняется перед выполнением любого метода в пакете com.home.service. В данном случае выводится сообщение о том, что метод будет выполнен.

    @AfterReturning(pointcut = "execution(* com.home.service.*.*(..))", returning = "result")
    public void afterServiceMethodExecution(JoinPoint joinPoint, Object result) {
        System.out.println("After execution of service method: " + joinPoint.getSignature().getName() + ". Returned: " + result);
    }

    //TODO: @AfterReturning - совет, который выполняется после успешного выполнения любого метода в пакете com.home.service. В данном случае выводится сообщение о том, что метод был выполнен, и также выводится результат, который он вернул.
}
