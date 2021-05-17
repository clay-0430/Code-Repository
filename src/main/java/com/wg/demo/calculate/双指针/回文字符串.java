package com.wg.demo.calculate.双指针;

/**
 * @author wg
 * @date 2021/4/7
 */
public class 回文字符串 {

    public static void main(String[] args) {
        String str = "abrcba";
        System.out.println(isSymmetry(str));
    }

    private static boolean isSymmetry(String str) {

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i++, j) || isPalindrome(str, i, j--);
            }
        }

        return false;
    }

    private static boolean isPalindrome(String str, int i, int j) {

        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
