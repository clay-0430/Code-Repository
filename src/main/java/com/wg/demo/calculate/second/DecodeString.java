package com.wg.demo.calculate.second;

import java.util.Stack;

/**
 * @Author : dongpo
 */
public class DecodeString {

    public String decodeString3(String s) {

        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                multiStack.push(multi);
                resStack.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                Integer count = multiStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(resStack.pop() + temp);
            } else {
                res.append(c);
            }
        }

        return res.toString();

    }


    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String decodeString1(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(s.charAt(i));
            i++;
        }
        return new String[]{res.toString()};
    }


}
