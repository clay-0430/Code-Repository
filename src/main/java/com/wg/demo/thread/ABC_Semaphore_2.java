package com.wg.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author wg
 * @date 2021/3/24
 */
public class ABC_Semaphore_2 {

    public static class Worker implements Runnable{

        private String name;
        private Semaphore current;
        private Semaphore next;
        private int count;

        public Worker(String name, Semaphore current, Semaphore next, int count) {
            this.name = name;
            this.current = current;
            this.next = next;
            this.count = count;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i < count; i++) {
                    current.acquire();
                    System.out.print(name);
                    next.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        ExecutorService executorService = newFixedThreadPool(3);
        int count = 10;
        executorService.execute(new Worker("A", semaphoreA, semaphoreB, count));
        executorService.execute(new Worker("B", semaphoreB, semaphoreC, count));
        executorService.execute(new Worker("C", semaphoreC, semaphoreA, count));

        executorService.shutdown();

    }


}
