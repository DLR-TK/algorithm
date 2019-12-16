package com.tk.algorithm.contains_duplicate_220;

import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("all")
public class Solution {


    /**
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(k)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Set<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (((TreeSet<Long>) record).ceiling((long)nums[i] - (long)t) != null &&
                    ((TreeSet<Long>) record).ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            }

            record.add((long) nums[i]);

            if (record.size() == k + 1) {
                record.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}
