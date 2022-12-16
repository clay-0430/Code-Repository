package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class MaxSubArray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        final int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = Math.max(res, dp[i-1]+nums[i]);
            }else {
                dp[i] = nums[i];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;

    }

    public static int maxSubArray1(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i], res);
        }

        return res;

    }


    public static int maxSubArray(int[] nums) {

        int pre = 0;
        int res = nums[0];

        for (int x : nums) {
            pre = Math.max(x, pre + x);
            res = Math.max(res, pre);
        }

        return res;
    }
}
