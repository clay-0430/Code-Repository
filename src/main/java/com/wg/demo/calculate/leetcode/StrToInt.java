package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class StrToInt {

    public static void main(String[] args) {
        String str = "243245h";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int i1 = chars[i] - '0';
            System.out.print(chars[i] + "---" + (chars[i] - '0'));
            System.out.println();
        }
    }
}
