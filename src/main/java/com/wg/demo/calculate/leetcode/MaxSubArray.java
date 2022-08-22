package com.wg.demo.calculate.leetcode;


/**
 * 最大子数组和
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pre = 0;
        for(int i=0; i< nums.length; i++){
            pre = Math.max(pre, pre+nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }
}
