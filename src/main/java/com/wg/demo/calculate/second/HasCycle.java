package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

/**
 * @Author : dongpo
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
    }

}
