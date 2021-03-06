package com.wg.demo.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wg
 * @date 2021/3/15
 */
public class ListAdd {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<ArrayList> arrayListClass = ArrayList.class;
        List<Integer> list = arrayListClass.newInstance();
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] arr2 = (Object[]) field.get(list);
            // 现在的list的容量是多少？
            System.out.println(arr2.length);
            // 新增一个值
            list.add(1);
            Object[] arr = (Object[]) field.get(list);
            // 现在的list的容量是多少？
            System.out.println(arr.length);
            List<Integer> addList = new ArrayList<>();
            // addAll一个15大小的
            for (int i = 0; i < 16; i++) {
                addList.add(i);
            }
            list.addAll(addList);
            Object[] arr1 = (Object[]) field.get(list);
            // 现在的list的容量是多少？
            System.out.println(arr1.length);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

