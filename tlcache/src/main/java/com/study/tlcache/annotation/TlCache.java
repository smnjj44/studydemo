package com.study.tlcache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TlCache {
    /**
     * 缓存key，支持SPEL表达式
     * @return
     */
    String key() default "";
}
