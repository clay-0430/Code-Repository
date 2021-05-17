package com.wg.demo.circulardependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wg
 * @date 2020/12/28
 */
@Service
public class Teacher {
    @Autowired
    private Student student;

    public Teacher () {
        System.out.println("Teacher init1:" + student);

    }

    public void teach () {
        System.out.println("teach:");
        student.learn();
    }

}
