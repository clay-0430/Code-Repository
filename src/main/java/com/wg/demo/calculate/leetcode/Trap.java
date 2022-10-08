package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class Trap {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(arr));
    }

    /**
     * for遍历 O(n^2)
     *
     * @param height
     * @return
     */
    private static int trap1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = Integer.MIN_VALUE;
            for (int j = i; j < height.length - 1; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }


    /**
     * dp，动态规划每个高度 O(n)
     *
     * @param height
     * @return
     */
    private static int trap2(int[] height) {
        int res = 0;
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        for (int i = length - 2; i > 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }
}
