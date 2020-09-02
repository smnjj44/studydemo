package com.study.tlcache.service;

import com.study.tlcache.annotation.TlCache;
import org.springframework.stereotype.Service;

/**
 * @author simonliang
 * @className TestService
 * @description TODO
 * @date 2020/8/31 6:06 下午
 */
@Service
public class TestService {

    @TlCache(key = "test")
    public String getName(){
        return "simon";
    }
}
