package com.wg.demo.calculate.双指针;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wg
 * @date 2021/4/7
 */
public class 有序数组的两数之和 {

    private static List<Integer> twoSum(int[] arr, int target) {
        List<Integer> res = Lists.newArrayList();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            }else {
                res.add(i);
                res.add(j);
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 9, 14, 15, 18};
        int target = 12;
        List<Integer> res = twoSum(arr, target);
        System.out.println(res);
    }

}
