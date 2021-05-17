package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/3/30
 */
public class QuickSort {

    private static void sort(int arr[], int L, int R) {

        int i = L;
        int j = R;
        int middle = arr[(L + R) / 2];
        while (i < j) {
            while (arr[i] < middle) {
                i++;
            }
            while (middle < arr[j]) {
                j--;
            }
            System.out.println("i:" + i + "--" + "j" + j);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + ",");
            }
        }
        if (L < i) {
            sort(arr, L, j - 1);
        }
        if (i < R) {
            sort(arr, i + 1, R);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 0, 44, 77, 33, 76, 28, 57, 90, 31, 63};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

}
