package com.wg.demo.calculate.second;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : dongpo
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        String s = removeKdigits("1432219", 3);
        System.out.println(s);
    }

    private static String removeKdigits(String num, int k) {

        Deque<Character> stack = new LinkedList<>();
        for(char c : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && c < stack.peek()){
                stack.pop();
                k--;
            }
            if( c != '0' || !stack.isEmpty()){
                stack.push(c);

            }
        }

        while( k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pollLast());
        }

        return res.length() == 0 ? "0" : res.toString();
    }


}
