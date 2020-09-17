package com.study.proxypattern.staticpattern;

import com.study.proxypattern.staticpattern.inter.SellPerfume;

/**
 * @author simonliang
 * @className XiaoHongSellProxy
 * @description 代理对某个私下方法进行增强，私下方法自定，增强为公共方法
 * @date 2020/9/9 12:18 上午
 */
public class XiaoHongSellProxy implements SellPerfume {

    private SellPerfume sellPerfumeFactory;

    //通过构建方法引入实现过该接口的类再进一步增强，这个增强是公共的，增强的方法是自己的需要引入
    public XiaoHongSellProxy(SellPerfume sellPerfumeFactory) {
        this.sellPerfumeFactory = sellPerfumeFactory;
    }
    @Override
    public void sellPerfume(double price) {
        doSomethingBeforeSell(); // 前置增强，增强的前后
        sellPerfumeFactory.sellPerfume(price);//自己的私下方法，围绕的增强方法
        doSomethingAfterSell(); // 后置增强，增强的后面
    }

    private void doSomethingBeforeSell() {
        System.out.println("小红代理购买香水前的额外操作...");
    }

    private void doSomethingAfterSell() {
        System.out.println("小红代理购买香水后的额外操作...");
    }
}
