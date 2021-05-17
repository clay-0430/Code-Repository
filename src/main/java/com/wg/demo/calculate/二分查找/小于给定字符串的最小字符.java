package com.wg.demo.calculate.二分查找;

/**
 * @author 汪贯
 * @desc
 */
public class 小于给定字符串的最小字符 {

    public static void main(String[] args) {
        char a[] = {'a', 'c', 'g', 'm', 'k'};
        char c = find(a, 'd');
        System.out.println(c);
    }

    private static char find(char[] arr, char target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (arr[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i < arr.length ? arr[i] : arr[0];
    }
}
