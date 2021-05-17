package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/3/9
 */
public class demo {
    public static void main(String[] args) {
        System.out.println((char)(65));
        System.out.println(getChar(1));
    }

    public static String getChar(int num) {
        String wgdz = "";
        while (true) {
            int i = num / 26;
            int j = num % 26;
            if (i == 0) {
                wgdz = (char) (65 + j - 1) + wgdz;
                break;
            }
            wgdz = (char) (65 + j - 1) + wgdz;
            num = i;
        }
        return wgdz;
    }
}
