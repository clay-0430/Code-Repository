package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            TreeNode temp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = temp;
            if (curNode.left!=null){
                queue.offer(curNode.left);
            }
            if (curNode.right!=null){
                queue.offer(curNode.right);
            }
        }

        return root;
    }


}
