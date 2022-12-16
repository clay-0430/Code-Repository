package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : dongpo
 */
public class DetectCycle {

    public ListNode detectCycle5(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (true){
            if (fast==null||fast.next==null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                break;
            }
        }

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }















    public ListNode detectCycle4(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public ListNode detectCycle3(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode cur = new ListNode(0);
        cur.next = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur = new ListNode(0);
        cur.next = head;

        while (hashSet.add(cur) != false) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }


    /**
     * a+(n+1)b+nc=2(a+b) \implies a=c+(n-1)(b+c)
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * <p>
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


}
