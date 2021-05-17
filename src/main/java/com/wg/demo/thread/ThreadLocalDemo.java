package com.wg.demo.thread;

/**
 * @author wg
 * @date 2021/4/1
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("main-thread:主线程");

        Thread thread = new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set("sub-thread:子线程");
            System.out.println(threadLocal.get());
        });

        thread.start();
        thread.join();
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }

}
