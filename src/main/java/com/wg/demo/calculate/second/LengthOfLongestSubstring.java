package com.wg.demo.calculate.second;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : dongpo
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "pwwkew";

        System.out.println(lengthOfLongestSubstring(str));
    }

    private static Integer lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
