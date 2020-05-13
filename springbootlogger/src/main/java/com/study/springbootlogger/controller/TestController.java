package com.study.springbootlogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Simon
 * @version 1.0.0
 * @Description
 * @ClassName TestController
 * @date 2020.05.09 15:57
 */
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/index")
    public String hello(){
        MDC.put("logId", UUID.randomUUID().toString());
        logger.info("info---------");
        logger.error("erro---------");
        logger.warn("warn------");
        logger.debug("debug------");
        return "hello man" ;
    }
}
