package com.wg.demo.calculate.leetcode.nodelist;

import com.wg.demo.calculate.leetcode.ListNode;

/**
 * 反转链表
 * @Author : dongpo
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {

        ListNode cur = head;

        return null;
    }

}
