package com.wg.demo.annotation;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : dongpo
 */
@Data
public class CustomerInfoExtVO {

    Map<String, String> properties = new ConcurrentHashMap<>();

    private  String name;

    private String phone;
}
