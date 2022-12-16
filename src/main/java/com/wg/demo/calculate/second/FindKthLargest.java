package com.wg.demo.calculate.second;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author : dongpo
 * 第k大的数
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4,9};
        final int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];

    }

    private static void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            int partion = partion(nums, left, right);
            quickSort(nums, left, partion - 1);
            quickSort(nums, partion + 1, right);
        }

    }

    private static int partion(int[] nums, int left, int right) {
        swap(nums, left, left + new Random().nextInt(right - left));
        int point = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[right]) {
                swap(nums, i, point);
                point++;
            }
        }
        swap(nums, point, right);
        return point;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private static void quickSort(int[] arr, int left, int right) {
//        if (left < right) {
//            int partion = partion(arr, left, right);
//            quickSort(arr, left, partion - 1);
//            quickSort(arr, partion + 1, right);
//        }
//    }

//    private static int partion(int[] arr, int left, int right) {
//        swap(arr, right, left + new Random().nextInt(right - left));
//        int pivot = right;
//        int pointer = left;
//
//        for (int i = left; i < right; i++) {
//            if (arr[i] >= arr[pivot]) {
//                swap(arr, i, pointer++);
//            }
//        }
//        swap(arr, pointer, pivot);
//        return pointer;
//    }
//
//    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
