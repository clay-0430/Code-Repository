package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean flag = false;

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode == null && flag) {
                return false;
            }
            if (curNode == null) {
                flag = true;
                continue;
            }
            queue.offer(curNode.left);
            queue.offer(curNode.right);
        }
        return true;
    }
}
