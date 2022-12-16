package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

/**
 * @Author : dongpo
 */
public class GetIntersectionNode {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
