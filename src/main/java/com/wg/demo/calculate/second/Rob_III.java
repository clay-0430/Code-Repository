package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : dongpo
 */
public class Rob_III {

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> mem = new HashMap<>();
        return rob2(root, mem);
    }

    private int rob2(TreeNode root, Map<TreeNode, Integer> mem) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (mem.containsKey(root)) {
            return mem.get(root);
        }
        if (root.left != null) {
            val = val + rob2(root.left.left, mem) + rob2(root.left.right, mem);
        }
        if (root.right != null) {
            val = val + rob2(root.right.left, mem) + rob2(root.right.right, mem);
        }

        int res = Math.max(val, rob2(root.left, mem) + rob2(root.right, mem));
        mem.put(root, res);
        return res;
    }
}
