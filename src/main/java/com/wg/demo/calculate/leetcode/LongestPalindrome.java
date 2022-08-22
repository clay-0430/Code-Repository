package com.wg.demo.calculate.leetcode;

/**
 * 最长回文字符串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }

    //暴力穷举
    private static String longestPalindromedp(String s) {

        int length = s.length();
        boolean dp[][] = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }




        return null;
    }



    //暴力穷举
    private static String longestPalindrome1(String s) {

        int length = s.length();
        int max = 0;
        String ans = "";
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > max) {
                    max = test.length();
                    ans = test;
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String s) {

        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;

    }


    //中心扩展法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = range(s, i, i);
            int length2 = range(s, i, i + 1);
            int len = Math.max(length1, length2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int range(String s, int i, int j) {
        int length = s.length();
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
