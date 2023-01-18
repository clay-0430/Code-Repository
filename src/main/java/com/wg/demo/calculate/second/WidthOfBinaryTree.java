package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * @Author : dongpo
 */
public class WidthOfBinaryTree {

    //做编号
    public int widthOfBinaryTree(TreeNode root) {

       return 0;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        int result = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(new TreeNode(1, root.left, root.right));
        while (!deque.isEmpty()) {
            int count = deque.size(),
                    startIndex = -1,
                    endIndex = -1;
            for (int i = 0; i < count; i++) {
                TreeNode node = deque.pop();
                endIndex = node.val;
                if (startIndex == -1) {
                    startIndex = node.val;
                }
                if (node.left != null) {
                    deque.addLast(new TreeNode(node.val * 2, node.left.left, node.left.right));
                }
                if (node.right != null) {
                    deque.addLast(new TreeNode(node.val * 2 + 1, node.right.left, node.right.right));
                }
            }
            result = Math.max(result, endIndex - startIndex + 1);
        }
        return result;
    }

}
