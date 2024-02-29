package com.ksk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

    @Aspect
    public class CustomAspect {
        @Before("@annotation(Loggable)")
        public void logMethod(JoinPoint joinPoint) {
            System.out.println(joinPoint);
        }
    }
}
