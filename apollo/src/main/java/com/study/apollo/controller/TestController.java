package com.study.apollo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Simon
 * @version 1.0.0
 * @Description
 * @ClassName TestController
 * @date 2020.04.30 18:47
 */
@RestController
public class TestController {
    @RequestMapping("/index")
    public String hello(){
        return "hello man";
    }
}
