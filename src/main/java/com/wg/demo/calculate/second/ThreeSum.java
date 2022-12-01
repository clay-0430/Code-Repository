package com.wg.demo.calculate.second;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : dongpo
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 2};
        final List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> temp = Lists.newArrayList(nums[i], nums[left], nums[right]);
                    res.add(temp);
                    break;
                }
            }
        }
        return res;
    }
}
