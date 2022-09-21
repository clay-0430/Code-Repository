package com.wg.demo.calculate.leetcode;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * @Author : dongpo
 */
public class Shuffle {

    public static void main(String[] args) {

        List list = Lists.newArrayList(1,2);
        shuffle(list);
        System.out.println(list);

    }

    private static void shuffle(List<Integer> list) {
        Random rnd = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, i, rnd.nextInt(i));
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        Integer ival = list.get(i);
        Integer jval = list.get(j);
        Integer jset = list.set(j, ival);
        Integer iset = list.set(i, jset);
        Integer res1 = list.get(i);
        Integer res2 = list.get(j);
        System.out.println();

//        list.set(i, list.set(j, list.get(i)));
    }

}
