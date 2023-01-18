package com.wg.demo.calculate.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : dongpo
 */
public class LongestConsecutive {

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums
     * @return
     */

    public int longestConsecutive3(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!num_set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (num_set.contains(curNum++)) {
                    curNum++;
                    curLength++;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }


    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //数组加入set去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        //遍历 以num为头最长的序列
        for (Integer num : nums) {
            //只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，因此数组中的每个数只会进入内层循环一次。
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                //下个数存在 长度 +1
                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {

        //用哈希表存储每个端点值对应连续区间的长度
        //若数已在哈希表中：跳过不做处理
        //若是新数加入：
        //取出其左右相邻数已有的连续区间长度 left 和 right
        //计算当前数的区间长度为：cur_length = left + right + 1
        //根据 cur_length 更新最大长度 max_length 的值
        //更新区间两端点的长度值
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int cur = 1 + left + right;
                if (cur > res) {
                    res = cur;
                }
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
    }
}
