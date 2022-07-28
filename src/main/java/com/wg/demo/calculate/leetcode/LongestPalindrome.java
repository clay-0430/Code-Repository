package com.wg.demo.calculate.leetcode;

/**
 * 最长回文字符串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;

        for(int i=0; i< s.length(); i++){
            int length1=range(s, i, i);
            int length2=range(s, i, i+1);
            int len = Math.max(length1, length2);
            if(len > (end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end +1);
    }

    public static int range(String s, int i, int j){
        int length = s.length();
        while(i>=0&&j<length&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

}
