package com.wg.demo.calculate.code;

/**
 * @Author : dongpo
 */
public class Threads {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("test")).start();

        class Test extends Thread{
            @Override
            public void run() {
                System.out.println("tets");
            }
        }

        new Test().start();

    }


}
