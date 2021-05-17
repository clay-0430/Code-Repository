package com.wg.demo.calculate.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wg
 * @date 2021/3/9
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        t1.setVal(15);

        TreeNode t2 = new TreeNode();
        t2.setVal(7);

        TreeNode t10 = new TreeNode();
        t10.setVal(10);

        TreeNode t11 = new TreeNode();
        t11.setVal(11);

        TreeNode t3 = new TreeNode();
        t3.setVal(20);
        t3.setLeft(t1);
        t3.setRight(t2);

        TreeNode t4 = new TreeNode();
        t4.setVal(9);
        t4.setLeft(t10);
        t4.setRight(t11);

        TreeNode t5 = new TreeNode();
        t5.setVal(3);
        t5.setLeft(t4);
        t5.setRight(t3);

        TreeNode[] treeNodes = new TreeNode[10];
        List<List<Integer>> lists = levelOrder(t5);
        System.out.println(lists);
    }
}
