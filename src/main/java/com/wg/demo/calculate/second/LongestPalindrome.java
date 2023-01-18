package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        if (null == s || s.length() < 2) {
            return s;
        }
        int maxLen;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = subStringLen(i, i, s);
            int len2 = subStringLen(i, i + 1, s);
            maxLen = Math.max(len1, len2);
            start = i - (maxLen / 2);
            end = i + (maxLen / 2);
        }
        return s.substring(start, end);
    }

    private Integer subStringLen(Integer i, Integer j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return j - i;
    }


//    public String longestPalindrome(String s) {
//
//        if (null == s || s.length() < 2) {
//            return s;
//        }
//
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            int len1 = range(s, i, i);
//            int len2 = range(s, i, i + 1);
//            int maxLen = Math.max(len1, len2);
//            start = i - (maxLen / 2);
//            end = i + (maxLen / 2);
//        }
//        return s.substring(start, end);
//    }
//
//    private static int range(String s, int i, int j) {
//        int len = 0;
//        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
//            i--;
//            j++;
//            len = j - i;
//        }
//        return len - 1;
//    }

}
