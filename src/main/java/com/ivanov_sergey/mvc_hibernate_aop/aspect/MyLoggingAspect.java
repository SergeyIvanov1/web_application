package com.ivanov_sergey.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.ivanov_sergey.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();
        System.out.println("\nBegin of " + methodName);

        //Aspect applied to method "*.*(..)" and here we are getting result of worked method
        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of : " + methodName);

        return targetMethodResult;
    }
}
