package com.wg.demo.calculate.leetcode;

import java.util.Stack;

/**
 * @Author : dongpo
 * <p>
 * 有效的括号数
 */
public class IsValid {

    public static void main(String[] args) {
        String str = "()[]{}";

    }

    private static Boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
