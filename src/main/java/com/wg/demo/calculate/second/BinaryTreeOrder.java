package com.wg.demo.calculate.second;

import com.wg.demo.calculate.tree.TreeNode;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * @Author : dongpo
 */
public class BinaryTreeOrder {

    /**
     * 递归前序遍历
     *
     * @param root
     */
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 递归中序遍历
     *
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 递归后续遍历
     *
     * @param root
     */
    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 迭代前序遍历
     *
     * @param root
     */
    private void preOrderI(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            System.out.println(curNode.val);
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
            }
            if (curNode.left != null) {
                nodeStack.push(curNode.right);
            }
        }
    }

    /**
     * 迭代中序遍历
     * 一直push左节点
     * @param root
     */
    private List<Integer> inOrderI(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 迭代后续遍历
     * 前序-中左右  调整顺序 中右左， 最后反转 左右中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}
