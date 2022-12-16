package com.wg.demo.calculate.second.dp;

/**
 * @Author : dongpo
 */
public class Fib {

    public static void main(String[] args) {
        int sum = fib4(10);

        System.out.println(sum);
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    private static int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private static int helper(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    private static int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fib4(int n) {
        int pre = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
