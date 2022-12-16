package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

/**
 * @Author : dongpo
 */
public class SortNodeList {

    public ListNode sortList1(ListNode head) {

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curNode = slow.next;
        slow.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(curNode);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

//    private static ListNode mergeSort(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode fast = head, slow = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode next = slow.next;
//        slow.next = null;
//        ListNode l1 = mergeSort(head);
//        ListNode l2 = mergeSort(next);
//        return merge(l1, l2);
//    }
//
//    private static ListNode merge(ListNode l1, ListNode l2) {
//        ListNode dummyNode = new ListNode(0);
//        ListNode cur = dummyNode;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = l1 == null ? l2 : l1;
//        return dummyNode.next;
//    }


//    public ListNode sortList(ListNode head) {
//        return mergeSort(head);
//    }
//
//    private ListNode mergeSort(ListNode head) {
//        if (head == null || head.next == null)//这个条件哪来的，我的想法是不能让fast.next为空
//            return head;
//        ListNode fast = head, slow = head;
//        //偶数个节点找到中心左边的节点，好让slow.next=null，分成两段链表
//        //记住这个判断条件，偶数结点会找靠左结点，奇数就是中间节点，能用到很多题上
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode next = slow.next;
//        slow.next = null;
//        ListNode left = mergeSort(head);
//        ListNode right = mergeSort(next);
//        return merge(left, right);
//    }
//
//    private ListNode merge(ListNode left, ListNode right) {  //两个链表merge模板，用到的地方也很多
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        while (left != null && right != null) {
//            if (left.val > right.val) {
//                cur.next = right;
//                right = right.next;
//            } else {
//                cur.next = left;
//                left = left.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = left != null ? left : right;
//        return dummy.next;
//    }

}
