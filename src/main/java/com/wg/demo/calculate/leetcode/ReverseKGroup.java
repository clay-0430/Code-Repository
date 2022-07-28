package com.wg.demo.calculate.leetcode;


import java.util.Stack;

/**
 * k个一组反转列表
 */
public class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = buildListNode(arr);
        ListNode res = reverseKGroup(listNode, 3);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;

        while (true) {
            Stack<ListNode> tempStack = new Stack();
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                tempStack.push(temp);
                temp = temp.next;
                count++;
            }
            if (count < k) {
                pre.next = head;
                break;
            }
            while (!tempStack.isEmpty()) {
                pre.next = tempStack.pop();
                pre = pre.next;
            }
            head = temp;
        }
        return dummyNode.next;
    }

    /**
     * 构造ListNode
     */
    private static ListNode buildListNode(int[] input) {
        ListNode first = null, last = null, newNode;
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                newNode = new ListNode(input[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
                    last = newNode;
                }
            }
        }
        return first;
    }


}
