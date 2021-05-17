package com.wg.demo.设计模式.责任链模式.工厂模式;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 汪贯
 * @desc
 */
public abstract class FactoryMethod {

    protected abstract Product creatProduct(String activity);

    public Product product(String activity, String name){
        Product product = creatProduct(activity);
        product.setName(name);
        return product;
    }

    @Data
    public static class Product{
        private String name;
    }

    @AllArgsConstructor
    public enum EnumProductType{

        activityOne("one"),
        activityTwo("two");

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
