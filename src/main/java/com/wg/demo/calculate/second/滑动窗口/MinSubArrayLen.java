package com.wg.demo.calculate.second.滑动窗口;

import java.util.Stack;

/**
 * @Author : dongpo
 */
public class MinSubArrayLen {


    private static int minSubArrayLen5(int target, int[] num) {
        int lo = 0, hi = num.length, min = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) >> 2;
            if (fixWindows(mid, target, num)) {
                hi = mid - 1;
                min = mid;
            } else {
                lo = mid + 1;
            }
        }
        return min;

    }

    private static boolean fixWindows(int size, int target, int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (i >= size) {
                sum -= num[i - size];
            }
            sum += num[size];
            if (sum >= target) {
                return true;
            }
        }
        return false;
    }


    private static int minSubArrayLen4(int target, int[] num) {
        int lo = 0, hi = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (hi < num.length) {
            sum += num[hi++];
            while (sum >= target) {
                min = Math.min(min, hi - lo);
                sum -= num[lo++];
            }
        }
        return min;
    }


    /**
     * 2层循环，暴力搜索
     *
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen3(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen4(7, nums);
        System.out.println(i);

    }

    public static int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public int minSubArrayLen2(int s, int[] nums) {
        int lo = 1, hi = nums.length, min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (windowExist(mid, nums, s)) {
                hi = mid - 1;//找到就缩小窗口的大小
                min = mid;//如果找到就记录下来
            } else
                lo = mid + 1;//没找到就扩大窗口的大小
        }
        return min;
    }

    //size窗口的大小
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }

}
