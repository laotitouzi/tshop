package com.tshop.token;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/22
 */
public class ExecutorTaskInterceptor implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        // 在后台中输出错误异常异常信息，通过log4j输出。
        Logger log = Logger.getLogger(o.getClass());
        log.info("execute workflow task in class : " + o.getClass().getName() + ":and method:" + method.getName());
        System.out.println("ExecutorTaskInterceptor");
    }
}
