package com.study.proxypattern.dynamicpattern;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author simonliang
 * @className SellProxyFactory
 * @description 动态代理 动态代理和静态代理最大区别在于这个代理工厂里面的构建传参对象的限制，例如这里例子，静态工厂只能传SellPerfume的实现者，这里动态工厂
 * 可以传任何的实现类，然后通过加强，在最后把实现的和工厂的联系起来通过最后接口执行即可。。
 *
 * 静态代理缺点：1）代理类和委托类实现了相同的接口，代理类通过委托类实现了相同的方法。
 * 这样就出现了大量的代码重复。如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
 * 2）代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
 * 如上的代码是只为UserManager类的访问提供了代理，但是如果还要为其他类如Department类提供代理的话，就需要我们再次添加代理Department的代理类。
 * @date 2020/9/16 6:32 下午
 */
public class SellProxyFactory implements InvocationHandler {
    /**
     * 代理的真实对象
     */
    private Object realObject;

    public SellProxyFactory(Object realObject) {
        this.realObject = realObject;
    }
    //这里不用像静态代理这样实现多个接口方法
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        doSomethingBefore();
        Object obj = method.invoke(realObject, objects);
        doSomethingAfter();
        return obj;
    }

    private void doSomethingAfter() {
        System.out.println("执行代理后的额外操作...");
    }

    private void doSomethingBefore() {
        System.out.println("执行代理前的额外操作...");
    }
}
