package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class Rob_II {

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        int i = robII(nums);
        System.out.println(i);
    }

    private static int robII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private static int rob(int[] nums, int start, int end) {
        int cur = 0, pre = 0, temp;
        for (int i = start; i < end; i++) {
            temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }


}
