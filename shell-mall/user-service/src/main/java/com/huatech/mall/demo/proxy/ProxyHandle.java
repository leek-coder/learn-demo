package com.huatech.mall.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author like
 * @date 2019-12-25 4:46 下午
 **/
public class ProxyHandle<T> implements InvocationHandler {


    private T target;

    public ProxyHandle(T target) {
        this.target = target;
    }

    /**
     * @param proxy  代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args   代表调用目标方法时传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("你好啊");
        Object invoke = method.invoke(target, args);
        System.out.println("执行结束");
        return invoke;
    }
}