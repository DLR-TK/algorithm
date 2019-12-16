package com.tk.algorithm.range_sum_query_immutable_303;

import com.tk.algorithm.range_sum_query_mutable_307.SegmentTree;

class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Error");
        }
        return segmentTree.query(i, j);
    }
}
