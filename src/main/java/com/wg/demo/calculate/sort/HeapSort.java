package com.wg.demo.calculate.sort;

import java.util.Arrays;

public class HeapSort {

    //左 2*i+1, 右 2*i+2
    //父 (i-1)/2

    public static void main(String[] args) {

        int arr[] = {1,2,3,9,5,8,4,2,7,10,100,30};
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
        while (heapSize>0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);//插入交换，跟父节点交换
            index = (index - 1) / 2;//当前位置给到父节点
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子坐标
        while (left < heapSize) {//下方还有孩子节点
            //两个孩子中谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父节点和孩子比较，谁的值大，把下标给把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
