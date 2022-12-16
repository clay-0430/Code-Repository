package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class LengthOfLIS {

    private static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        int result = 1;
        for(int i=0; i< length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;

    }
}
