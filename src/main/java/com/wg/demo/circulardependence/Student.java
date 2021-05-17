package com.wg.demo.circulardependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wg
 * @date 2020/12/28
 */
@Service
public class Student {
    @Autowired
    private Teacher teacher;

    public Student () {
        System.out.println("Student init:" + teacher);
    }

    public void learn () {
        System.out.println("Student learn");
    }
}
