package com.study.proxypattern.staticpattern;

import com.study.proxypattern.staticpattern.inter.SellPerfume;

/**
 * @author simonliang
 * @className ChanelFactory
 * @description
 * @date 2020/9/9 12:10 上午
 */
public class ChanelFactory implements SellPerfume {
    /**
     * chanel的作用
     * @param price
     */
    @Override
    public void sellPerfume(double price) {
        System.out.println("我是chanel:"+price);
    }
}
