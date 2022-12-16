package com.wg.demo.calculate.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {88, 12, 4, 65, 99, 13, 542, 67, 4, 8, 1, 56, 37};
        quickSort2(arr, 0, arr.length - 1);
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

        swap(arr, right, left + new Random().nextInt(right - left));

        int pointer = left;


        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[right]) {
                swap(arr, i, pointer++);
            }
        }
        swap(arr, pointer, right);
        return pointer;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int partion = patition2(arr, left, right);
            quickSort2(arr, left, partion - 1);
            quickSort2(arr, partion + 1, right);
        }
    }

    private static int patition2(int[] arr, int left, int right) {
        swap2(arr, right, left + new Random().nextInt(right - left));
        int pivot = right;
        int pointer = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[pivot]) {
                swap2(arr, i, pointer++);
            }
        }
        swap2(arr, pointer, pivot);
        return pointer;
    }


    private static void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
