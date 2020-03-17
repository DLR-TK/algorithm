package com.tk.algorithm.positive_sequence_1543;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    public int[][] findContinuousSequence(int target) {
//
//        int l = 1;
//        int r = 2;
//        int sum = l + r;
//
//        List<int[]> res = new ArrayList<>();
//
//        while (l <= target / 2 && l < r) {
//            if (sum < target) {
//                r++;
//                sum += r;
//            } else if (sum > target) {
//                sum -= l;
//                l++;
//            } else {
//                int[] arr = new int[r-l+1];
//                for (int i = l; i <= r; i++) {
//                    arr[i-l] = i;
//                }
//                res.add(arr);
//
//                sum -= l;
//                l++;
//            }
//        }
//
//        return res.toArray(new int[res.size()][]);
//    }
    public int[][] findContinuousSequence(int target) {

        int l = 1;
        int sum = 0;

        List<int[]> res = new ArrayList<>();

        for (int r = 1; r <= target / 2 + 1; r++) {
            sum += r;
            while (sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                int[] arr = new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    arr[i-l] = i;
                }
                res.add(arr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
