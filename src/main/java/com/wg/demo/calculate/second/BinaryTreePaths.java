package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.*;

/**
 * @Author : dongpo
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    public void dfs(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, res, path + "->");
        }
        if (root.right != null) {
            dfs(root.right, res, path + "->");
        }
    }


    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val);
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode curNode = (TreeNode) stack.pop();
            if (curNode.left == null && curNode.right == null) {
                res.add(path);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
                stack.push(path + "->" + curNode.right.val);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
                stack.push(path + "->" + curNode.left.val);
            }
        }
        return res;
    }

    public List<String> binaryTreePaths3(TreeNode root) {

        List<String> res = new ArrayList<>();
        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root.val);

        while (!queue.isEmpty()) {
            TreeNode curNode = (TreeNode) queue.poll();
            String path = (String) queue.poll();

            if (curNode.left == null && curNode.right == null) {
                res.add(path);
            }

            if (curNode.left != null) {
                queue.offer(curNode.left);
                queue.offer(path + "->" + curNode.left.val);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                queue.offer(path + "->" + curNode.right.val);
            }
        }
        return res;
    }


}
