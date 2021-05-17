package com.wg.demo.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wg
 * @date 2021/3/31
 */
public class Subsets_回朔 {

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

}
