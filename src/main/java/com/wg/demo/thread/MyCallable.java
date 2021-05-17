package com.wg.demo.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wg
 * @date 2021/2/18
 */
public class MyCallable implements Runnable{
    @Override
    public void run() {
        System.out.println(new Random());
    }

    public Integer call() {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new MyCallable());
        }
        service.shutdown();


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");

//        MyRunnable mr = new MyRunnable();
//        FutureTask<Integer> ft = new FutureTask<>(mr);
//        Thread thread = new Thread(ft);
//        thread.start();
//        System.out.println(ft.get());
    }
}
