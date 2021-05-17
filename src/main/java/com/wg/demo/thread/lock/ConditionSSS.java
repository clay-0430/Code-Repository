package com.wg.demo.thread.lock;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 汪贯
 * @desc
 */
public class ConditionSSS {

    private static Lock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static int state = 0;

    public static class Thread_A extends Thread {
        @Override
        public void run() {
            while (state % 3 != 0) {
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            conditionB.signal();
        }
    }

    public static class Thread_B extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            while (state % 3 != 1) {
                conditionB.await();
            }
            System.out.print("A");
            conditionC.signal();
        }
    }

    public static class Thread_C extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            while (state % 3 != 2) {
                conditionC.await();
            }
            System.out.print("A");
            conditionA.signal();
        }
    }

    public static void main(String[] args) {
        new Thread_A().start();
        new Thread_B().start();
        new Thread_C().start();
    }
}
