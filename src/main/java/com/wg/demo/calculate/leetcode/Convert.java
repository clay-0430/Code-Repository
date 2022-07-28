package com.wg.demo.calculate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字型打印字符串
 */
public class Convert {

    public static void main(String[] args) {

        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);

    }

    private static String convert(String s, int numRows){

        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1){
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }


}
