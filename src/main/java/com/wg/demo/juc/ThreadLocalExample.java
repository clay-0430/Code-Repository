package com.wg.demo.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wg
 * @date 2021/3/4
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }

}
