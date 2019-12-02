package com.tk.algorithm.range_sum_query_mutable307;

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

    public void update(int i, int val) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Error");
        }
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Error");
        }
        return segmentTree.query(i, j);
    }
}
