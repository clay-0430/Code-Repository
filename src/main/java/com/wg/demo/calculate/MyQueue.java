package com.wg.demo.calculate;

import java.util.Stack;

/**
 * @author wg
 * @date 2021/3/9
 */
public class MyQueue {

    //输入栈
    private Stack<Integer> a;
    //输出栈
    private Stack<Integer> b;

    public MyQueue(){
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x){
        a.push(x);
    }

    public int pop(){
        if (b.isEmpty()){
            if (!a.isEmpty()){
               return b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek(){
        if (b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty(){
        return a.isEmpty() & b.isEmpty();
    }

}
