package com.wg.demo.calculate.leetcode.nodelist;

import com.wg.demo.calculate.leetcode.ListNode;

/**
 * @Author : dongpo
 * 归并排序
 */
public class ListPartion2 {

    private ListNode listPartion2(ListNode head, int pivot) {

        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;

        while (head != null) {
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = head.next;
        }

        ListNode res = new ListNode(0);
        if (sH!=null){
            res.next = sH;
            if (eH!=null){
                sT.next = eH;
                eT.next = bH;
            }else {
                sT.next = bH;
            }
        }else if(eH!=null){
            res.next = eH;
            eT.next = bH;
        }else {
            res.next=bH;
        }
        return res;
    }


}
