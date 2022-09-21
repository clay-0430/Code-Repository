package com.wg.demo.calculate.leetcode;

import java.util.List;
import java.util.Stack;

public class IsValidBST {

    private void inOrder(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
        }
    }
}
