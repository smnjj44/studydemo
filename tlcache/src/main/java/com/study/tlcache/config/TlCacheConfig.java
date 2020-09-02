package com.study.tlcache.config;

import com.study.tlcache.aspect.TlCacheAspect;
import com.study.tlcache.filter.TlCacheFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simonliang
 * @className TlCacheConfig
 * @description TODO
 * @date 2020/8/31 5:23 下午
 */
@Configuration
public class TlCacheConfig {
    @Bean
    public FilterRegistrationBean idempotentParamtFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        TlCacheFilter filter = new TlCacheFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("thread-local-cache-filter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public TlCacheAspect threadLocalCacheAspect() {
        return new TlCacheAspect();
    }
}
