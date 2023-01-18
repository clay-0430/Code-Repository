package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class FindLength {

    public static void main(String[] args) {
        int[][] dp = new int[10][10];

        System.out.println(dp[1][1]);
    }

    /**
     * DP
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        int res = -1;
        int Alength = A.length, Blength = B.length;
        int[][] dp = new int[Alength + 1][Blength + 1];

        for (int i = 1; i <= Alength; i++) {
            for (int j = 1; j <= Blength; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int findLength1(int[] A, int[] B) {
        int res = -1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0;
                while (A[i + k] == B[j + k]) {
                    k++;
                }
                res = Math.max(res, k);
            }
        }
        return res;
    }


    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ans = 0;
        // 窗口扩大，A必定从0开始，枚举窗口大小
        for (int len = 1; len <= n; len++) {
            int maxLen = maxLength(A, B, 0, B.length - len, len);
            ans = Math.max(ans, maxLen);
        }
        // 窗口不变，A从0开始到结束，枚举B的起点
        for (int i = 0; i < m - n - 1; i++) {
            int maxLen = maxLength(A, B, 0, i + 1, n);
            ans = Math.max(ans, maxLen);
        }
        // 窗口缩小，B必定从0开始，枚举窗口大小
        for (int len = n; len >= 1; len--) {
            int maxLen = maxLength(A, B, A.length - len, 0, len);
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }

    public int maxLength(int[] A, int[] B, int aStart, int bStart, int windowLen) {
        int maxLen = 0;
        int subLen = 0;
        for (int i = 0; i < windowLen; i++) {
            if (A[aStart] == B[bStart]) {
                subLen++;
            } else {
                // 只有不相等再更新，减少比较次数
                maxLen = Math.max(maxLen, subLen);
                subLen = 0;
            }
            aStart++;
            bStart++;
        }
        maxLen = Math.max(maxLen, subLen);
        return maxLen;
    }

}
