package com.wg.demo.calculate.second;

import java.util.Stack;

/**
 * @Author : dongpo
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "{}{}[]()";
    }

    private static Boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if ('{' == c) {
                stack.push('}');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('(' == c) {
                stack.push(')');
            }else if (stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
