package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class GetIntersectionNode {


    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A = headA, B = headB;

        while (A != B) {
            A = A != null ? A.next : B;
            B = B != null ? B.next : A;
        }
        return A;

    }
}
