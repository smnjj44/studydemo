package com.study.proxypattern.dynamicpattern.test;

import com.study.proxypattern.dynamicpattern.RedWineFactory;
import com.study.proxypattern.dynamicpattern.SellProxyFactory;
import com.study.proxypattern.dynamicpattern.inter.SellWine;
import com.study.proxypattern.staticpattern.ChanelFactory;
import com.study.proxypattern.staticpattern.inter.SellPerfume;
import org.springframework.cglib.proxy.Proxy;

/**
 * @author simonliang
 * @className Test
 * @description
 * @date 2020/9/16 6:46 下午
 */
public class Test {
    public static void main(String[] args) {
        // 实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        // 实例化代理工厂，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory = new SellProxyFactory(redWineFactory);
        // 实例化代理对象，该对象可以代理售卖红酒
        SellWine sellWineProxy = (SellWine) Proxy.newProxyInstance(redWineFactory.getClass().getClassLoader(),
                redWineFactory.getClass().getInterfaces(),
                sellProxyFactory);
        // 代理售卖红酒
        sellWineProxy.sellWine(1999.99);
        sellWineProxy.buyWine(999);

        //香水经销商 要代理的真实对象
        ChanelFactory chanelFactory = new ChanelFactory();
        //代理实现类和前后增强 通过实现InvocationHandler，代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，
        //最终代理对象的调用处理程序会调用真实对象的方法
        SellProxyFactory sellProxyFactory2 = new SellProxyFactory(chanelFactory);
        //实例化代理对象，使接口执行方法不用重写接口还要这个方法自带增强类
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象，我们来看下方法中的参数
         * 第一个参数：people.getClass().getClassLoader()，使用handler对象的classloader对象来加载我们的代理对象
         * 第二个参数：people.getClass().getInterfaces()，这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 第三个参数：handler，我们将代理对象关联到上面的InvocationHandler对象上
         */
        SellPerfume sellPerfumeProxy = (SellPerfume) Proxy.newProxyInstance(chanelFactory.getClass().getClassLoader(),chanelFactory.getClass().getInterfaces(),sellProxyFactory2);
        sellPerfumeProxy.sellPerfume(2999.99);

        //1。实现类 2。增强代理 3。增强代理和实现联系起来 4。直接执行接口类方法
    }
}
