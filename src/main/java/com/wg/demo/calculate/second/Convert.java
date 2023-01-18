package com.wg.demo.calculate.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : dongpo
 * Z字型转换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class Convert {

    public static void main(String[] args) {
        String S = "PAYPALISHIRING";
        int numRows = 3;
        convert(S, numRows);
    }

    private static String convert(String s, int numRows) {

        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> builderTemp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builderTemp.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            builderTemp.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builderTemp) {
            res.append(builder);
        }
        return res.toString();
    }

}
