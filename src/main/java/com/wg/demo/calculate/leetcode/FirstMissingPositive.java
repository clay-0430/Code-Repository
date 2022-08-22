package com.wg.demo.calculate.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static int firstMissingPositiveByHash(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return nums[i];
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
//        int i = firstMissingPositiveByHash(nums);
        int i = firstMissingPositive2(nums);
        System.out.println(i);
    }

    /**
     * 自定义hash
     */
    public static int firstMissingPositive2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
