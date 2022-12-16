package com.wg.demo.calculate.second;

import java.util.Stack;

/**
 * @Author : dongpo
 */
public class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.inStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            stackIn2Out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            stackIn2Out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void stackIn2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
