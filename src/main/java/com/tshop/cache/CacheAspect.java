package com.tshop.cache;

import com.tshop.redis.RedisClientTemplate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/25
 */
@Aspect
@Component
public class CacheAspect {

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Around("@annotation(updateCache)")
    public Object updateCache(final ProceedingJoinPoint pjp, UpdateForCache updateCache) throws Throwable {
        String key = getCacheKey(pjp, updateCache);
        Object value = pjp.proceed();      //跳过缓存,到后端查询数据
        if (value == null) return value;
        if (updateCache.expire() <= 0) {      //如果没有设置过期时间,则无限期缓存
            redisClientTemplate.set(key, value, 0);
        } else {                    //否则设置缓存时间
            redisClientTemplate.set(key, value, updateCache.expire());
        }
        return value;


    }

    @Around("@annotation(cache)")
    public Object loadFromCache(final ProceedingJoinPoint pjp, LoadFromCache cache) throws Throwable {
        String key = getCacheKey(pjp, cache);
        Object value = redisClientTemplate.get(key);    //从缓存获取数据
        if (value != null) return value;       //如果有数据,则直接返回

        value = pjp.proceed();      //跳过缓存,到后端查询数据
        if (cache.expire() <= 0) {      //如果没有设置过期时间,则无限期缓存
            redisClientTemplate.set(key, value, 0);
        } else {                    //否则设置缓存时间
            redisClientTemplate.set(key, value, cache.expire());
        }
        return value;
    }

    /**
     * 获取缓存的key值
     *
     * @param pjp
     * @param cache
     * @return
     */
    private String getCacheKey(ProceedingJoinPoint pjp, LoadFromCache cache) {
        StringBuilder buf = new StringBuilder();
        buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());
        if (cache.key().length() > 0) {
            buf.append(".").append(cache.key());
        }

        Object[] args = pjp.getArgs();
        if (cache.keyMode() == KeyMode.DEFAULT) {
            Annotation[][] pas = ((MethodSignature) pjp.getSignature()).getMethod().getParameterAnnotations();
            Method mmm = ((MethodSignature) pjp.getSignature()).getMethod();
            Annotation an1 = pas[0][0];
            for (int i = 0; i < pas.length; i++) {
                for (Annotation an : pas[i]) {
                    if (an instanceof CacheKey) {
                        buf.append(".").append(args[i].toString());
                        break;
                    }
                }
            }
        } else if (cache.keyMode() == KeyMode.BASIC) {
            for (Object arg : args) {
                if (arg instanceof String) {
                    buf.append(".").append(arg);
                } else if (arg instanceof Integer || arg instanceof Long || arg instanceof Short) {
                    buf.append(".").append(arg.toString());
                } else if (arg instanceof Boolean) {
                    buf.append(".").append(arg.toString());
                }
            }
        } else if (cache.keyMode() == KeyMode.ALL) {
            for (Object arg : args) {
                buf.append(".").append(arg.toString());
            }
        }

        return buf.toString();
    }

    private String getCacheKey(ProceedingJoinPoint pjp, UpdateForCache cache) {

        StringBuilder buf = new StringBuilder();
        buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());
        if (cache.key().length() > 0) {
            buf.append(".").append(cache.key());
        }

        Object[] args = pjp.getArgs();
        if (cache.keyMode() == KeyMode.DEFAULT) {
            Annotation[][] pas = ((MethodSignature) pjp.getSignature()).getMethod().getParameterAnnotations();
            Method mmm = ((MethodSignature) pjp.getSignature()).getMethod();
            Annotation an1 = pas[0][0];
            for (int i = 0; i < pas.length; i++) {
                for (Annotation an : pas[i]) {
                    if (an instanceof CacheKey) {
                        buf.append(".").append(args[i].toString());
                        break;
                    }
                }
            }
        } else if (cache.keyMode() == KeyMode.BASIC) {
            for (Object arg : args) {
                if (arg instanceof String) {
                    buf.append(".").append(arg);
                } else if (arg instanceof Integer || arg instanceof Long || arg instanceof Short) {
                    buf.append(".").append(arg.toString());
                } else if (arg instanceof Boolean) {
                    buf.append(".").append(arg.toString());
                }
            }
        } else if (cache.keyMode() == KeyMode.ALL) {
            for (Object arg : args) {
                buf.append(".").append(arg.toString());
            }
        }

        return buf.toString();
    }
}
