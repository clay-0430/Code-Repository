package com.wg.demo.动态代理;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author wg
 */
public class CarHandler implements InvocationHandler {

    private Car car;

    public CarHandler(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.err.println("before");
        method.invoke(car, objects);
        System.err.println("after");
        return null;
    }
}
