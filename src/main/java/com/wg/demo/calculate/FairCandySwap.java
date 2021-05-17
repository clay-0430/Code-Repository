package com.wg.demo.calculate;

import java.util.Arrays;

/**
 * @author wg
 * @date 2021/2/2
 */
public class FairCandySwap {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 5};
        int[] B = new int[]{2, 4};

        int[] ans = new int[2];
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int j : B) {
            sumB += j;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int temp = sumA - (sumA + sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == temp) {
                ans[0] = A[i];
                ans[1] = B[j];
                break;
            } else if (A[i] - B[j] > temp) {
                j++;
            } else if (A[i] - B[j] < temp) {
                i++;
            }
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
