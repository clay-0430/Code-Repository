package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return 0;
    }

    private static int dfs(TreeNode root, int preSum) {

        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

    public static int sumNumbersQueue(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        int sum = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer num = sumQueue.poll();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }


}
