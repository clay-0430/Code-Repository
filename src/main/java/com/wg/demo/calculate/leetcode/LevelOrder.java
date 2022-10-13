package com.wg.demo.calculate.leetcode;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : dongpo
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = Lists.newArrayList();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = Lists.newArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                tempList.add(poll.val);
            }
            res.add(tempList);
        }
        return res;
    }
}
