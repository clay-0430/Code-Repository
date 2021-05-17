package com.wg.demo.设计模式.责任链模式.工厂模式;

/**
 * @author 汪贯
 * @desc
 */
public class ProductFactory extends FactoryMethod {

    @Override
    protected Product creatProduct(String activity) {
        if (EnumProductType.activityOne.getName().equals(activity)) {
            return new OneProduct();
        } else if (EnumProductType.activityTwo.getName().equals(activity)){
            return new TwoProduct();
        }
        return null;
    }

    public static class OneProduct extends Product {

    }

    public static class TwoProduct extends Product {

    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new ProductFactory();
        Product product = factoryMethod.product("one", "two");
        System.out.println(product.getName());
    }


}
