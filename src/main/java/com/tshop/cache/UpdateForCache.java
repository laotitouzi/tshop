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
@Target({ElementType.METHOD})
public @interface UpdateForCache  {
    public String key() default "";     //缓存key
    public KeyMode keyMode() default KeyMode.DEFAULT;       //key的后缀模式
    public int expire() default 0;      //缓存多少秒,默认无限期
}