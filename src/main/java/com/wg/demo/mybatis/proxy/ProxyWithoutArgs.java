package com.wg.demo.mybatis.proxy;

import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wg
 * @date 2021/3/11
 */
@Service
public class ProxyWithoutArgs implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" 🧱 🧱 🧱 进入代理调用处理器 ");
        return "success-----";
    }

}
