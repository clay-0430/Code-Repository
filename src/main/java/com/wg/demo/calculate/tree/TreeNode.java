package com.wg.demo.calculate.tree;

import lombok.Builder;
import lombok.Data;

/**
 * @author wg
 * @date 2021/3/9
 */
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
