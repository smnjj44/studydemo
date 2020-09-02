package com.study.tlcache.filter;


import com.study.tlcache.utils.TlCacheUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author simonliang
 * @className TlCacheFilter
 * @description TODO
 * @date 2020/8/31 5:20 下午
 */
public class TlCacheFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        // 执行完后清除缓存
        TlCacheUtil.removeCache();
    }
}
