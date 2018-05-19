package com.cesuokanc.cache.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * @desc
 * @author lirb
 * @datetime 2018/4/23,23:05
 */
@Slf4j
@Component
@Aspect
public class TimeCostCheckAspect {

    @Pointcut("@annotation(com.cesuokanc.cache.aspect.TimeCostCheck)")
    public void timeCostCheck(){

    }

    @Before("timeCostCheck()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @Around("timeCostCheck()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.warn("==>{} : TIME_COST_CHECK : Use Time:{} ms", joinPoint, end - start);
            return result;
        } catch (Throwable throwable) {
            long end = System.currentTimeMillis();
            log.warn("==>{} : TIME_COST_CHECK : Use Time:{} ms", joinPoint, end - start);
            throw throwable;
        }
    }
}
