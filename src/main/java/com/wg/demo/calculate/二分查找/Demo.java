package com.wg.demo.calculate.二分查找;

/**
 * @author 汪贯
 * @desc
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 19};
        int target = demooo(arr, 6);
        System.out.println(target);
    }

    private static int demooo(int[] arr, int target) {

        int i = 0, j = arr.length;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;

    }

}
