package com.wg.demo.calculate.leetcode;

import java.util.*;

/**
 * @Author : dongpo
 * 锯齿状遍历二叉树
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (reverse){
                    Collections.reverse(temp);
                    reverse = !reverse;
                }
                res.add(temp);
            }



        }

        return null;
    }
}
