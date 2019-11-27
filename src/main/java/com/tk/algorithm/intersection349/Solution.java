package com.tk.algorithm.intersection349;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> recode = new HashSet<>();
        for (int i = 0; i < nums1.length ; i++) {
            recode.add(nums1[i]);
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length ; i++) {
            if (recode.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] nums = new int[result.size()];
        int i = 0;
        for (int res : result) {
            nums[i++] = res;
        }
        return nums;
    }
}
