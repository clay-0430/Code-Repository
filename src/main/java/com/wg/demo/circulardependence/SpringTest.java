package com.wg.demo.circulardependence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wg
 * @date 2020/12/28
 */
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
        applicationContext.getBean(Teacher.class).teach();
    }
}
