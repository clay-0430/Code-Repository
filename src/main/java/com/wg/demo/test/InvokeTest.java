package com.wg.demo.test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

/**
 * @author wg
 * @date 2021/1/18
 */
public class InvokeTest {

    public static volatile int counter = 5;

    public static void main(String[] args) {

//        public class Singleton {
//            private volatile static Singleton instance = null;
//            private Singleton() {}
//            public static Singleton getInstance() {
//                if (instance == null) {
//                    synchronized (Singleton.class) {// 1
//                        if (instance == null) {// 2
//                            instance = new Singleton();// 3
//                        }
//                    }
//                }
//                return instance;
//            }
//        }

//        1、线程 1 进入 getInstance() 方法。
//        2、由于 instance 为 null，线程 1 在 //1 处进入 synchronized 块。
//        3、线程 1 前进到 //3 处，但在构造函数执行之前，使实例成为非 null。
//        4、线程 1 被线程 2 预占。
//        5、线程 2 检查实例是否为 null。因为实例不为 null，线程 2 将 instance 引用返回给一个构造完整但部分初始化了的 Singleton 对象。
//        6、线程 2 被线程 1 预占。
//        7、线程 1 通过运行 Singleton 对象的构造函数并将引用返回给它，来完成对该对象的初始化。
//        try {
//
//
//            Map<String, String> config = Maps.newConcurrentMap();
//            config.put("distribute.level","");
//            config.put("settlement.type", " ");
//            config.put("distribute.lesssvel","wsda");
//
////            DistributionConfigBO bo =new DistributionConfigBO();
////            bo.setDistributeLevel("2");
////            Map<String, String> config = Maps.newConcurrentMap();
////            Field[] fields = DistributionConfigBO.class.getDeclaredFields();
////
////            for (Field field : fields) {
////                field.setAccessible(true);
////                String fieldName = field.getName();
////                Object value = field.get(bo);
////                config.put(fieldName, value.toString());
////            }
////
////
//////            Arrays.stream(fields).forEach(field -> {
//////                try {
//////                    config.put(field.getName(), field.get(bo).toString());
//////                } catch (IllegalAccessException e) {
//////                }
//////            });
////
////            System.out.println(config);
//        } catch (Exception e) {
//
//        }
    }
}
