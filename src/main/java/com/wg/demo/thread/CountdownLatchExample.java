package com.wg.demo.thread;

import org.springframework.util.StopWatch;

import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author wg
 * @date 2021/2/18
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
//        final int totalThread = 10;
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        ExecutorService executorService = Executors.newCachedThreadPool();
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("等待1s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await(3000, TimeUnit.MILLISECONDS);
        watch.stop();
        System.out.println(watch.getTotalTimeMillis());
    }
}
