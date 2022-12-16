package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

import java.util.*;

/**
 * @Author : dongpo
 */
public class DeleteDuplicates {

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 没有节点或者只有一个节点，必然没有重复元素
        if (head == null || head.next == null) return head;

        // 当前节点和下一个节点，值不同，则head的值是需要保留的，对head.next继续递归
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            // 当前节点与下一个节点的值重复了，重复的值都不能要。
            // 一直往下找，找到不重复的节点。返回对不重复节点的递归结果
            ListNode notDup = head.next.next;
            while (notDup != null && notDup.val == head.val) {
                notDup = notDup.next;
            }
            return deleteDuplicates(notDup);
        }
    }


    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        //维护一个不变的结点guard
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode pre = guard;
        ListNode cur = head;
        while (cur != null) {
            //如果出现重复的情况如下
            //相等的结点则跳过,走到相同值元素的最后一步
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            //如果pre和cur之间没有重复节点，pre后移
            if (pre.next == cur) {
                pre = pre.next;
            }
            //将cur的前指针向后移动一位
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return guard.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        //使用一个map去存储结点出现的次数，大于1的就删除
        ListNode cur = head;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> l1 = new ArrayList<Integer>();
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        //找到次数大于0的map的key
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() > 1) l1.add(entry.getKey());
        }
        ListNode pre = new ListNode();
        cur = head;
        pre.next = head;
        //开始遍历
        while (cur != null) {
            if (l1.contains(cur.val)) {
                if (cur.val == head.val) head = head.next;
                pre.next = cur.next;
            } else pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

}
