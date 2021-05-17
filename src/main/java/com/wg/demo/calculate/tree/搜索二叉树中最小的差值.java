package com.wg.demo.calculate.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 汪贯
 * @desc
 */
public class 搜索二叉树中最小的差值 {

    static int res = Integer.MAX_VALUE, pre = -1;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.setVal(4);
        treeNode.left = new TreeNode();
        TreeNode n1 = treeNode.left;
        n1.setVal(2);
        treeNode.right = new TreeNode();
        TreeNode n2 = treeNode.right;
        n2.setVal(6);
        TreeNode n3 = n1.left;
        n3.setVal(1);
        TreeNode n4 = n1.left;
        n4.setVal(3);
        int val = calculate(treeNode);
        System.out.println(val);
    }

    private static int calculate(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        calculate(treeNode.left);
        if (pre == -1) {
            pre = treeNode.val;
        }else {
            res = Math.min(res, treeNode.val - pre);
            pre = treeNode.val;
        }
        calculate(treeNode.right);
        return 0;

    }


}
