package com.wg.demo.calculate.second;

import com.wg.demo.calculate.leetcode.TreeNode;

import java.util.*;

/**
 * @Author : dongpo
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();
    Map<TreeNode, TreeNode> temp = new HashMap<>();

    public List<List<Integer>> pathSu3(TreeNode root, int targetSum) {

        if (root == null) {
            return res;
        }

        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode curNode = (TreeNode) queue.poll();
            int val = (Integer) queue.poll();
            if (curNode.left == null && curNode.right == null && val == 0) {
                List<Integer> path = getPath1(curNode);
                res.add(new ArrayList<>(path));
            }
            if (curNode.left != null) {
                queue.offer(curNode.left);
                queue.offer(val + curNode.left.val);
                map.put(curNode.left, curNode);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                queue.offer(val + curNode.right.val);
                map.put(curNode.right, curNode);
            }
        }
        return res;
    }

    public List<Integer> getPath1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            res.add(root.val);
            root = temp.get(root);
        }
        return res;
    }


    List<List<Integer>> ret = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, res, path, targetSum);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> path, int targetSum) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        targetSum = targetSum - root.val;
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, res, path, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, res, path, targetSum);
        }
    }

}
