package com.wg.demo.calculate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList();
        for (int fixed = 0; fixed < nums.length; fixed++) {
            if (fixed > 0 && nums[fixed] == nums[fixed - 1]) {
                continue;
            }
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                if (fixed == left) {
                    left++;
                    continue;
                }
                if (fixed == right) {
                    right--;
                    continue;
                }
                int tempSum = nums[fixed] + nums[left] + nums[right];
                if (tempSum < 0) {
                    left++;
                } else if (tempSum > 0) {
                    right--;
                } else {
                    List<Integer> tempList = new ArrayList();
                    tempList.add(nums[fixed]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    res.add(tempList);
                    left++;
                }
            }
        }
        return res;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


}
