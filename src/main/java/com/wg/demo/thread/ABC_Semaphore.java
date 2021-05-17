package com.wg.demo.thread;

import java.util.concurrent.Semaphore;

/**
 * @author wg
 * @date 2021/3/24
 */
public class ABC_Semaphore {

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    static class ThreadA extends Thread{

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.print("A");
                    semaphoreB.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread{

        @Override
        public void run() {
            try{
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    static class ThreadC extends Thread{


        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.print("C");
                    semaphoreA.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}
