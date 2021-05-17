package com.wg.demo.calculate.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪贯
 * @desc
 */
public class 最长子序列 {

    public static String findLongestWord(String s, List<String> d) {
        String longestStr = "";
        for (String target : d) {
            int i = s.length(), j = target.length();
            if (i > j) {
                isSubstr(s, target);
                longestStr = target;
            }
        }
        return longestStr;
    }

    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        findLongestWord(s, d);
    }
}
