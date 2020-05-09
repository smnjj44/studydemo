package com.study.apollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Simon
 * @version 1.0.0
 * @Description
 * @ClassName JavaConfigBean
 * @date 2020.05.09 10:45
 */
@Configuration
public class JavaConfigBean {
    //key:timeout 20:默认值
    @Value("${timeout:20}")
    private int timeout;

    public int getTimeout() {
        return timeout;
    }
}
