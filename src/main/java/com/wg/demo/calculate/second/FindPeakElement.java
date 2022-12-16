package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class FindPeakElement {

    public static void main(String[] args) {

        int i = 16;
        System.out.println(i >> 1);

//        int[] nums = {1,2,1,3,5,6,4};
//
//        int peakElement = findPeakElement(nums);
//
//        System.out.println(peakElement);
    }

    /**
     * 首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
     * 根据上述结论，我们就可以使用二分查找找到峰值
     * 查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
     * 根据左右指针计算中间位置 m，并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，r = m，如果 m + 1 较大，则右侧存在峰值，l = m + 1
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * 首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
     * 根据上述结论，我们就可以使用二分查找找到峰值
     * 查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
     * 根据左右指针计算中间位置 m，并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，r = m，如果 m + 1 较大，则右侧存在峰值，l = m + 1
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }


}
