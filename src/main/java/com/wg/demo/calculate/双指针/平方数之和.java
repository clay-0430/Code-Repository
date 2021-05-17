package com.wg.demo.calculate.双指针;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪贯
 * @desc
 */
public class 平方数之和 {

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(18));

    }

    private static List<Long> judgeSquareSum(Integer sum) {
        List<Long> list = Lists.newArrayList();
        long left = 0;
        long right = (long) Math.sqrt(sum);

        while (left <= right) {
            long target = left * left + right * right;
            if (target == sum) {
                list.add(left);
                list.add(right);
                return list;
            } else if (target < sum) {
                left++;
            } else {
                right--;
            }
        }
        return Lists.newArrayList();
    }

}
