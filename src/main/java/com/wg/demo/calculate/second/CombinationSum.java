package com.wg.demo.calculate.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : dongpo
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int end = candidates.length - 1;
        dfs(candidates, 0, end, path, res, target);

        return res;
    }

    private void dfs(int[] candidates, int begin, int end, List<Integer> path, List<List<Integer>> res, int target) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < end; i++) {
            path.add(candidates[i]);
            dfs(candidates, i, end, path, res, target - candidates[i]);
            path.remove(path.size() - 1);
        }


    }
}
