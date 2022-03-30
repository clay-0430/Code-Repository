package com.wg.demo.动态代理;

/**
 * @author wg
 */
public class Audi implements Car {
    @Override
    public void drive(String driverName, String carName) {
        System.err.println("Audi is driving... " + "driverName: " + driverName + ", carName" + carName);
    }
}
