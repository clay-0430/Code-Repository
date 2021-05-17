package com.wg.demo.annotation;

/**
 * @author wg
 * @date 2021/2/5
 */
public class Student {

    @CherryAnnotation(name = "Tom", age = 1, score = {99, 98, 96})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");
        }
    }

}
