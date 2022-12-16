package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : dongpo
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int curSize = stack.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                temp.add(pop.val);
            }
            res.add(temp);
        }

        return res;
    }

}
