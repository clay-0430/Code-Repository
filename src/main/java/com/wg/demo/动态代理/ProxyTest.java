package com.wg.demo.动态代理;

import org.junit.Test;
import org.springframework.cglib.proxy.Proxy;

/**
 * @author wg
 */
public class ProxyTest {

    @Test
    public void proxyTest() throws Exception {
        Car audi = (Car) Proxy.newProxyInstance(Car.class.getClassLoader(), new Class<?>[] {Car.class}, new CarHandler(new Audi()));
        audi.drive("name1", "audi");
    }

}
