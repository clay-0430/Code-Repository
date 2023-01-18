package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class IsBalance {

    public boolean flag = true;

    private boolean isBalance(TreeNode root) {
        maxDepth(root);
        return flag;
    }

    private int maxDepth(TreeNode root) {

        if (root==null|| !flag){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }

}
