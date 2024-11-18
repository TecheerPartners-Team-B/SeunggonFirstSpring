package com.example.firstproject;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Around("execution(* com.example.*.service*.*(..))")
    public void checkToken() {
        System.out.println("transaction start");

//        Object ret = joinPoint.proceed();

        System.out.println("transaction end");
    }
}
