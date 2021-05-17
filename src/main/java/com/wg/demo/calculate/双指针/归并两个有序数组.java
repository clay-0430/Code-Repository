package com.wg.demo.calculate.双指针;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wg
 * @date 2021/4/7
 */
public class 归并两个有序数组 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0, 0}, arr2 = {2, 5, 6};
        merge(arr1, 3, arr2, 3);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i);
        }
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, length = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                arr1[length--] = arr2[j--];
            } else if (j < 0) {
                arr1[length--] = arr1[i--];
            } else if (arr1[i] > arr2[j]) {
                arr1[length--] = arr2[j--];
            } else {
                arr1[length--] = arr1[i--];
            }
        }
    }
}
