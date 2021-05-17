package com.wg.demo.thread;

/**
 * @author wg
 * @date 2021/3/22
 */
public class ABC_Sync {

    public static class ThreadPrinter implements Runnable{

        private String name;
        private Object prev;
        private Object self;

        public ThreadPrinter(String name, Object prev, Object self){
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0){
                synchronized (prev){
                    synchronized (self){
                        System.out.print(name);
                        count--;
                        self.notifyAll();
                    }
                    try {
                        if (count == 0){
                            prev.notifyAll();
                        }else {
                            prev.wait();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
//        ThreadPrinter ta = new ThreadPrinter("A", c, a);
//        ThreadPrinter tb = new ThreadPrinter("B", a, b);
//        ThreadPrinter tc = new ThreadPrinter("C", b, c);
//
//        new Thread(ta).start();
//        Thread.sleep(100);
//        new Thread(tb).start();
//        Thread.sleep(100);
//        new Thread(tc).start();
//        Thread.sleep(100);

        new Thread(new ThreadPrinter("A", c, a)).start();
        new Thread(new ThreadPrinter("B", a, b)).start();
        new Thread(new ThreadPrinter("C", b, c)).start();

    }
}
