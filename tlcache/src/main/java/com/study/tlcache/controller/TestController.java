package com.study.tlcache.controller;

import com.study.tlcache.annotation.TlCache;
import com.study.tlcache.service.TestService;
import com.study.tlcache.utils.TlCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simonliang
 * @className TestController
 * @description TODO
 * @date 2020/8/31 6:03 下午
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public String test(){
        String s = null;
        for (int i = 0; i < 10; i++) {
            s = testService.getName();
        }
        return s;
    }
}
