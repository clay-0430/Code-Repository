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

    public static void main(String[] args) {
        try {


            Map<String, String> config = Maps.newConcurrentMap();
            config.put("distribute.level","");
            config.put("settlement.type", " ");
            config.put("distribute.lesssvel","wsda");

//            DistributionConfigBO bo =new DistributionConfigBO();
//            bo.setDistributeLevel("2");
//            Map<String, String> config = Maps.newConcurrentMap();
//            Field[] fields = DistributionConfigBO.class.getDeclaredFields();
//
//            for (Field field : fields) {
//                field.setAccessible(true);
//                String fieldName = field.getName();
//                Object value = field.get(bo);
//                config.put(fieldName, value.toString());
//            }
//
//
////            Arrays.stream(fields).forEach(field -> {
////                try {
////                    config.put(field.getName(), field.get(bo).toString());
////                } catch (IllegalAccessException e) {
////                }
////            });
//
//            System.out.println(config);
        } catch (Exception e) {

        }
    }
}
