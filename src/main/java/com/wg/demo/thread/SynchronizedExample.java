package com.wg.demo.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wg
 * @date 2021/2/18
 */
public class SynchronizedExample {

    public synchronized void func1() {

            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }

    }


    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());

        System.out.println();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> e1.func1());
        executor.execute(() -> e2.func1());

    }

}
