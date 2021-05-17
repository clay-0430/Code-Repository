package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/3/31
 */
public class SerchMatrix_01 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = new int[matrix.length];
        int count = -1;
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
            if (i + 1 < arr.length && target > arr[i] && target < arr[i + 1]) {
                count = i;
                break;
            }
            if (i == arr.length - 1) {
                count = i;
            }
        }
        if (count < 0) {
            return false;
        } else {
            return binarySearch(matrix[count], target);
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int count = (left + right) / 2;
            if (arr[count] > target) {
                right = count - 1;
            } else if (arr[count] < target) {
                left = count + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean binarySerach(int[] arr, int target) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int middle = (L + R) / 2;
            if (arr[middle] < target) {
                L = middle + 1;
            } else if (arr[middle] > target) {
                R = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
