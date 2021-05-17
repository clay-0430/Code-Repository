package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/3/30
 */
public class ReverseLeftWords {

    private static String reverse1(String str, int n) {
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    private static String reverse2(String str, int n){

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverse1("sadsadwdqwf", 5));
        System.out.println(reverse2("sadsadwdqwf", 5));

    }

}
