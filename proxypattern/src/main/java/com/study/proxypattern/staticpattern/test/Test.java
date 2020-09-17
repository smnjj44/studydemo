package com.study.proxypattern.staticpattern.test;

import com.study.proxypattern.staticpattern.ChanelFactory;
import com.study.proxypattern.staticpattern.XiaoHongSellProxy;

/**
 * @author simonliang
 * @className Test
 * @description
 * @date 2020/9/9 12:25 上午
 */
public class Test {
    public static void main(String[] args) {
        ChanelFactory factory = new ChanelFactory();
        XiaoHongSellProxy proxy = new XiaoHongSellProxy(factory);
        proxy.sellPerfume(1999.99);
    }
}
