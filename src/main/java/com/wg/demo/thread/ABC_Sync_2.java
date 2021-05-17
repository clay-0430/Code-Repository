package com.wg.demo.thread;

import lombok.SneakyThrows;

/**
 * @author wg
 * @date 2021/3/22
 */
public class ABC_Sync_2 {

    public static class PrintThread implements Runnable {

        private String name;

        private Object prev;

        private Object self;

        public PrintThread(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @SneakyThrows
        @Override
        public void run() {

            int count = 10;

            while (count > 0) {
                synchronized (prev){
                    synchronized (self){
                        System.out.print(name);
                        count--;
                        self.notifyAll();
                    }
                    prev.wait();
                }

            }
        }

    }

    public static void main(String[] args) throws Exception{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        new Thread(new PrintThread("A", c, a)).start();
        Thread.sleep(100);
        new Thread(new PrintThread("B", a, b)).start();
        Thread.sleep(100);
        new Thread(new PrintThread("C", b, c)).start();
    }

}
