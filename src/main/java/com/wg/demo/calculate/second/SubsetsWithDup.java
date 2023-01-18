package com.wg.demo.calculate.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : dongpo
 * <p>
 * 含重复子集
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsWithDup {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, 0);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
