package com.wg.demo.calculate.second;

import com.wg.demo.calculate.tree.TreeNode;

/**
 * @Author : dongpo
 */
public class IsValidBST {

    private int preVal = Integer.MIN_VALUE;

    private boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left != null) {
            return isValidBST(root.left);
        }

        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;

        return isValidBST(root.right);
    }
}
