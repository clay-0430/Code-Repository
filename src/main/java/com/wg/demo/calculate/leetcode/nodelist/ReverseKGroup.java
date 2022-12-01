package com.wg.demo.calculate.leetcode.nodelist;

import com.wg.demo.calculate.leetcode.ListNode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : dongpo
 */
public class ReverseKGroup {


    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("Java");
        String test1 = "Java";
        String test3 = "Java1234";
        String test2 = "1234Java";

        Matcher matcher = pattern.matcher(test2);
        System.out.println(matcher.lookingAt());//返回true

        Matcher matcher2 = pattern.matcher(test3);
        System.out.println(matcher2.lookingAt());//返回true

//        Pattern pattern = Pattern.compile("姓名称谓名称名字");
//        String test1 = "姓名";
//        String test2 = "客户姓名";
//        String test3 = "姓名客户";
//        Matcher matcher = pattern.matcher(test1);
//        System.out.println(matcher.matches());
//        matcher = pattern.matcher(test2);
//        System.out.println(matcher.matches());
//        matcher = pattern.matcher(test3);
//        System.out.println(matcher.matches());
//
//        matcher = pattern.matcher(test1);
//        System.out.println(matcher.lookingAt());//返回true
//        matcher = pattern.matcher(test2);
//        System.out.println(matcher.lookingAt());//返回true
//        matcher = pattern.matcher(test3);
//        System.out.println(matcher.lookingAt());//返回true

//        LocalTime time = LocalTime.now();
//        System.out.println(time);
//        LocalTime ss = LocalTime.parse(time.toString());
//        System.out.println(ss);
//
//        LocalDate now = LocalDate.now();
//        System.out.println(now.toString().replace("-", "."));

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (true){
            int count = 0;
            while (count<k){
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            if (count<k){
                pre.next = head;
                break;
            }
            while (!stack.isEmpty()){
                pre.next = stack.pop();
                pre = pre.next;
            }
            head = temp;
        }
        return dummy.next;
    }

}
