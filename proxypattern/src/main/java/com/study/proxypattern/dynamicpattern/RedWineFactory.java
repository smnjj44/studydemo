package com.study.proxypattern.dynamicpattern;

import com.study.proxypattern.dynamicpattern.inter.SellWine;

/**
 * @author simonliang
 * @className RedWineFactory
 * @description
 * @date 2020/9/16 6:45 下午
 */
public class RedWineFactory implements SellWine {
    @Override
    public void sellWine(double price) {
        System.out.println("成功售卖一瓶红酒，价格：" + price + "元");
    }

    @Override
    public void buyWine(double price) {
        System.out.println("回购红酒"+price);
    }
}
