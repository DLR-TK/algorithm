package com.tk.algorithm.non_overlapping_intervals_435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /**
     * 时间复杂度O(n^2)
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        //memo[i]表示使用intervals[0...i]的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return intervals.length - res;
    }


    /**
     * 时间复杂度 O(n)  贪心算法优化 以区间尾排序
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= intervals[pre][1]) {
                    res++;
                    pre = i;
                }
        }

        return intervals.length - res;
    }
}
