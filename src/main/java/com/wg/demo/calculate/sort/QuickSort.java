package com.wg.demo.calculate.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {88, 12, 4, 65, 99, 13, 542, 67, 4, 8, 1, 56, 37};
        quickSort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partion = partion(arr, left, right);
            quickSort(arr, left, partion - 1);
            quickSort(arr, partion + 1, right);
        }
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = right;
        int pointer = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[pivot]) {
                swap(arr, i, pointer++);
            }
        }
        swap(arr, pointer, pivot);
        return pointer;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
