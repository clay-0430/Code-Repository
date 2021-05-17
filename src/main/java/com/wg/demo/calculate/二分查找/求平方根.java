package com.wg.demo.calculate.二分查找;

/**
 * @author 汪贯
 * @desc
 */
public class 求平方根 {

    public static void main(String[] args) {
        int target = 8;
        int res = sqrt(target);
        System.out.println(res);
    }

    private static int sqrt(int target) {
        if (target <= 1) {
            return target;
        }
        int i = 0, j = target;
        while (i <= j) {
            int m = (i + j) / 2;
            int res = target / m;
            if (m == res) {
                return m;
            } else if (m < res) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return j;

    }

}
