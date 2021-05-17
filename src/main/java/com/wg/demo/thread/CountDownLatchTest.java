package com.wg.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author 汪贯
 * @desc
 */
public class CountDownLatchTest {

    private static int SIZE = 7;
    private static CountDownLatch countDownLatch;

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(SIZE);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 爷爷被妖怪抓走了!");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 爷爷被救了!");
        }).start();

        for (int i = 0; i < 7; i++) {
            new HuLuWa().start();
        }
    }

    static class HuLuWa extends Thread {
        @Override
        public void run() {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ":我去救爷爷了!");
        }
    }
}
