package com.wg.demo.calculate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : dongpo
 */
public class ReorderList {


    /**
     * 1、找到链表中点，分割
     * 2、反转后半段链表
     * 3、拼接前半段和后半段
     */
    //归并排序-递归
    //时间复杂度O(nlogn)，空间复杂度O(logn)，其中n是链表的长度。空间复杂度主要取决于递归调用的栈空间。
    //经典归并，许多题用到这个模板。
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }


//    void merge(ListNode l1, ListNode l2) {
//        ListNode temp1;
//        ListNode temp2;
//        while (l1 != null && l2 != null) {
//            temp1 = l1.next;
//            temp2 = l2.next;
//            l1.next = l2;
//            l1 = temp1;
//            l2.next = l1;
//            l2 = temp2;
//        }
//    }


    /**
     * 使用list 先放进去， 双指针获取
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        List<ListNode> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(j).next = null;
    }

    /**
     * 双端链表：跟链表相似，练习下
     *
     * @param head
     */
    public void reorderList3(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode cur = head;
        LinkedList<ListNode> queue = new LinkedList<>();

        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }

        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }

        if (cur != null) {
            cur.next = null;
        }

    }
}
