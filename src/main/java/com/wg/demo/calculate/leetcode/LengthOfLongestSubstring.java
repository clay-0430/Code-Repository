package com.wg.demo.calculate.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "asdowsss";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        Map<Character, Integer> curMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (curMap.containsKey(s.charAt(i))) {
                left = curMap.get(s.charAt(i));
            }
            curMap.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }
}
