package com.cesuokanc.cache.aspect;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author liruibo
 * @time 2018/1/5
 * @desc
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(20)
public @interface TimeCostCheck {
}
