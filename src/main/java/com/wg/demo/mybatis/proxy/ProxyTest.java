package com.wg.demo.mybatis.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wg
 * @date 2021/3/11
 */
public class ProxyTest {

//    public static void main(String[] args) {
//        Subject subject = new SubjectImpl();
//        Subject proxy = (Subject) Proxy
//                .newProxyInstance(
//                        subject.getClass().getClassLoader(),
//                        subject.getClass().getInterfaces(),
//                        new ProxyInvocationHandler(subject)
//                );
//        subject.say();
//        System.out.println("======================");
//        String say = proxy.say();
//        System.out.println("************************");
//    }
public static void main(String[] args) {
    Subject subject = new Subject() {
        @Override
        public String say() {
            return null;
        }
    };
    Subject proxy = (Subject) Proxy
            .newProxyInstance(
                    subject.getClass().getClassLoader(),
                    new Class[]{Subject.class},
                    new ProxyWithoutArgs());

    String say = proxy.say();
    System.out.println();
    /**
     * 打印输出如下
     * 调用处理器：🧱 🧱 🧱 进入代理调用处理器
     */
}
}
