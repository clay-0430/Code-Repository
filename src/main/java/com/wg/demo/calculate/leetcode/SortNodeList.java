package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class SortNodeList {

    private static ListNode sortNodeList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode head1 = sortNodeList(head);
        ListNode head2 = sortNodeList(cur);

        ListNode dummyNode = new ListNode(0);
        ListNode res = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                dummyNode.next = head1;
                head1 = head1.next;
            } else {
                dummyNode.next = head2;
                head2 = head2.next;
            }
            dummyNode = dummyNode.next;
        }
        dummyNode.next = head1 != null ? head1 : head2;

        return res.next;

    }
}
