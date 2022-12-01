package com.wg.demo.calculate.leetcode.nodelist;

import com.wg.demo.calculate.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 判断是否是回文链表
 * 1、使用栈
 * 2、使用数组
 * 3、双指针节约一半空间
 * 4、递归
 *
 * @Author : dongpo
 */
public class IsPalindrome {

    public boolean isPalindrome1(ListNode head) {

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode temp2 = head;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            if (temp2!=pop){
                return false;
            }
            temp2 = temp2.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {

        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null){
            list.add(temp.val);
            temp=temp.next;
        }
        int left = 0, right=list.size()-1;
        while (left<right){
            if (list.get(left) != list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {

        if (head==null){
            return true;
        }

        ListNode halfNode = halfNode(head);
        ListNode secondHalfNode = reverseListNode(halfNode.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfNode;
        boolean res = true;
        while (p2!=null){
            if (p1.val!=p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        halfNode.next = reverseListNode(secondHalfNode);
        return res;
    }

    private ListNode halfNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode node){
        ListNode cur = node;
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next =null;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
