package com.wg.demo.calculate.leetcode;

import java.util.Stack;

public class IsSymmetric {

    public boolean isSymmetric2(TreeNode root) {
        if (root==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if ((left==null && right==null)){
                continue;
            }
            if (left==null||right==null){
                return false;
            }
            if (left.val!= right.val){
                return false;
            }
            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
            stack.push(left.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if (left.val!= right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }





    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
