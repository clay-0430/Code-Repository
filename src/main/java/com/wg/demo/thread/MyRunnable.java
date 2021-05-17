package com.wg.demo.thread;

/**
 * @author wg
 * @date 2021/2/18
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("123123");
    }

    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}
