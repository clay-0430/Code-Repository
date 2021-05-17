package com.wg.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wg
 * @date 2021/4/1
 */
public class Demo2<T> {
    public static void main(String[] args) {
//限制T 为String 类型

        Demo2 demo = new Demo2();

//获取string类型

        List array = new ArrayList();

        array.add("test");

        array.add("doub");

        Object listFisrt = demo.getListFisrt(array);

        System.out.println(listFisrt);

//获取Integer类型 T 为Integer类型

        Demo2 demo2 = new Demo2();

        List nums = new ArrayList();

        nums.add(12);

        nums.add(13);
    }

    /**
     * 这个只能传递T类型的数据
     * <p>
     * 返回值 就是Demo 实例化传递的对象类型
     *
     * @param data
     * @return
     */

    private T getListFisrt(List data) {
        if (data == null || data.size() == 0) {
            return null;

        }
        T result = (T)data.get(0);
        return result;

    }
}
