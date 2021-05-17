package com.wg.demo.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wg
 * @date 2021/2/18
 */
public class LockExample {

    private Lock lock = new ReentrantLock();
    final int totalThread = 10;
    CountDownLatch countDownLatch = new CountDownLatch(totalThread);

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.func());
        executorService.execute(() -> example.func());
    }
}
