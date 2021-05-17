package com.wg.demo.dubbo;

/**
 * @author wg
 * @date 2021/3/23
 */
public class ShutCommond implements Commond {
    @Override
    public void excute() {
        System.out.println("shutDown!");
    }
}
