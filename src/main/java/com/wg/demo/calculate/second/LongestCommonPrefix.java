package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class LongestCommonPrefix {

    private String longestCommonPrefix(String[] strs) {
        String flag = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(flag)) {
                flag = flag.substring(0, flag.length() - 1);
            }
        }
        return flag;
    }
}
