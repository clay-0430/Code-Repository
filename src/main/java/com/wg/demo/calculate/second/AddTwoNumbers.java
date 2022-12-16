package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.ListNode;

import java.util.List;

/**
 * @Author : dongpo
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode cur = prev;
        //当l1 不等于null或l2 不等于空时，就进入循环
        while (l1 != null || l2 != null) {
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x = l1 != null ? l1.val : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 != null ? l2.val : 0;
            //将两个链表的值，进行相加，并加上进位数
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            //将求和数赋值给新链表的节点，
            //注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
            //所以这个时候要创一个新的节点，将值赋予节点
            cur.next = new ListNode(sum);
            //将新链表的节点后移
            cur = cur.next;
            //当链表l1不等于null的时候，将l1 的节点后移
            if (l1 != null) {
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;
    }

    private ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
//        def addTwoNumbers(self, l1, l2):
//        if not l1:
//        return l2
//        elif not l2:
//        return l1
//        sum = l1.val+l2.val
//        if sum > 9:
//        return ListNode(sum-10, self.addTwoNumbers(ListNode(1, None), self.addTwoNumbers(l1.next, l2.next)))
//        else:
//        return ListNode(sum, self.addTwoNumbers(l1.next, l2.next));
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int sum = l1.val + l2.val;
        if (sum > 9) {
            return new ListNode(sum - 10, addTwoNumbers3(new ListNode(1, null), addTwoNumbers3(l1.next, l2.next)));
        } else {
            return new ListNode(sum, addTwoNumbers3(l1.next, l2.next));
        }

    }

    private ListNode sumTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(carry % 10);
            cur.next = temp;
            cur = cur.next;
            carry /= 10;
        }
        return res.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(t % 10);
            t /= 10;
            cur.next = temp;
            cur = cur.next;
        }
        return res.next;

    }

}
