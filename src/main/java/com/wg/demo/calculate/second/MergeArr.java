package com.wg.demo.calculate.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : dongpo
 */
public class MergeArr {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果列表为空,或者当前区间与上一区间不重合,直接添加
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则的话,我们就可以与上一区间进行合并
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }

}
