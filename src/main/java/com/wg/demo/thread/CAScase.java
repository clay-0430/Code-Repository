package com.wg.demo.thread;

/**
 * @author wg
 * @date 2021/3/1
 */
public class CAScase {

    public volatile int value;

    public void add(){
        value ++ ;
    }
}
