package com.tk.algorithm.contains_duplicate_219;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class Solution {


    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(k)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            if (record.size() == k + 1) {
                record.remove(nums[i-k]);
            }
        }
        return false;
    }
}
