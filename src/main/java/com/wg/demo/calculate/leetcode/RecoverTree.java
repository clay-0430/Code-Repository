package com.wg.demo.calculate.leetcode;

import java.util.Stack;

public class RecoverTree {

    public void recoverTree(TreeNode root) {

        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode one = null;
        TreeNode two = null;
        TreeNode pre = root;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }



            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node);
            }


        }

    }

}
