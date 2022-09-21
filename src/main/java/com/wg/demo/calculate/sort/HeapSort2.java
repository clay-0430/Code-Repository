package com.wg.demo.calculate.sort;

import java.util.Arrays;

/**
 * @Author : dongpo
 */
public class HeapSort2 {

    //father (i-1)/2
    //left 2*i+1, right 2*i+2

    public static void main(String[] args) {
        int[] arr = {88, 12, 4, 65, 99, 13, 542, 67, 4, 8, 1, 56, 37};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;//left坐标
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ?
                    left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
