package com.tshop.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface CacheKey {}