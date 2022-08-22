package com.wg.demo.calculate.leetcode;

/**
 * 最长子序列
 */
public class LengthOfLIS {

    private static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        int res = 1;

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,6,7,3,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }


}
