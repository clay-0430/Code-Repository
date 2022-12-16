package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : dongpo
 */
public class ReorderList {

    public void reorderList4(ListNode head) {

        ListNode midleNode = getMidleList1(head);
        ListNode l2 = midleNode.next;
        l2 = reverseNode(l2);
        midleNode.next = null;

        merge2(head, l2);

    }

    private void merge2(ListNode h1, ListNode h2) {
        ListNode h1Temp = h1;
        ListNode h2Temp = h2;
        while (h1 != null && h2 != null) {

            h1Temp = h1;
            h2Temp = h2;

            h1.next = h2;

            h1.next = h2;

        }
    }


    private ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode getMidleList1(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }


    public void reorderList(ListNode head) {

        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        int i = 0, j = nodeList.size() - 1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        nodeList.get(j).next = null;
    }

    public void reorderList2(ListNode head) {

        if (head == null) {
            return;
        }

        //1、中间截取listNode
        //2、反转后半段list
        //3、合并两个list
        ListNode midleList = getMidleList(head);
        ListNode l1 = head;
        ListNode l2 = midleList.next;
        midleList.next = null;

        l2 = reverseListNode(l2);

        merge(l1, l2);


    }

    private ListNode getMidleList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void merge(ListNode l1, ListNode l2) {

        ListNode tempL1;
        ListNode tempL2;

        while (l1 != null && l2 != null) {
            tempL1 = l1;
            tempL2 = l2;

            l1.next = l2;
            l1 = tempL1;
            l2.next = l1;
            l2 = tempL2;
        }

    }

    private ListNode reverseListNode(ListNode l2) {

        ListNode pre = null;
        ListNode cur = l2;
        while (l2 != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public void reorderList3(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int i = 0, j = nodeList.size() - 1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        nodeList.get(j).next = null;
    }


}
