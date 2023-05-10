package com.example.application;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(public * com.example.application.service.MyService.*(..))")
    public void myPointcut() {}

    @Before("myPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String message = String.format("Before Executing %s.%s", className, methodName);
        System.out.println(message);

    }

    @After("myPointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String message = String.format("After Executing %s.%s", className, methodName);
        System.out.println(message);
    }

    @Around("myPointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // This code will be executed before the method call
        System.out.println("Before method call");

        // Call the method that was intercepted
        Object result = joinPoint.proceed();

        // This code will be executed after the method call
        System.out.println("After method call");

        return result;
    }
}
