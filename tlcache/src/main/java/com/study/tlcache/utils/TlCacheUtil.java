package com.study.tlcache.utils;

import java.util.Map;

public class TlCacheUtil {
    private static ThreadLocal<Map> tlcCache = new ThreadLocal<>();
    public static void set(Map map){
        tlcCache.set(map);
    }

    public static Map get(){
        return tlcCache.get();
    }

    public static void removeCache(){
        tlcCache.remove();
    }

    public static void removeCache(String key){
        Map cache = tlcCache.get();
        if (cache != null){
            cache.remove(key);
        }
    }
}
