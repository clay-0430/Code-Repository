package com.wg.demo.calculate.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列， 回溯+递归
 */
public class Permute {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }

    private static List<List<Integer>> permute1(int[] arr) {
        List<List<Integer>> res = Lists.newArrayList();
        Deque<Integer> path = new ArrayDeque<>(arr.length);
        boolean[] used = new boolean[arr.length];
        dfs1(arr, path, 0, used, res);
        return res;
    }

    private static void dfs1(int[] arr, Deque<Integer> path, Integer depth, boolean[] used, List<List<Integer>> res) {

        if (depth==arr.length){
            res.add(Lists.newArrayList(path));
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]){
                path.add(arr[i]);
                used[i]=true;
                dfs1(arr, path, depth+1, used, res);
                path.removeLast();
                used[i]=false;
            }
        }

    }


    private static List<List<Integer>> permute(int[] num) {

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        dfs(num, path, 0, used, res);
        return res;

    }

    private static void dfs(int[] num, Deque<Integer> path, int depth, boolean[] used, List<List<Integer>> res) {

        if (depth == num.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                path.add(num[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(num, path, depth + 1, used, res);

                path.removeLast();
                used[i] = false;
                System.out.println("递归之后 => " + path);
            }
        }

    }
}
