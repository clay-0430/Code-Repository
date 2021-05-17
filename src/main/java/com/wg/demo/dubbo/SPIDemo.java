package com.wg.demo.dubbo;

import java.util.ServiceLoader;

/**
 * @author wg
 * @date 2021/3/23
 */
public class SPIDemo {

    public static void main(String[] args) {
        ServiceLoader<Commond> load = ServiceLoader.load(Commond.class);
        for (Commond commond : load) {
            commond.excute();
        }
    }
}
