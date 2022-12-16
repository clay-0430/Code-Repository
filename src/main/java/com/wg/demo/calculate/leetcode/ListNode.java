package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode pre;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next, ListNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
