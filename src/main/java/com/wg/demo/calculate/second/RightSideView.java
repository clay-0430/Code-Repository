package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.right != null) {
                    queue.add(curNode.right);
                } else if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (i == 0) {
                    res.add(curNode.val);
                }
            }
        }
        return res;
    }
}
