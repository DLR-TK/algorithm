package com.tk.algorithm.two_sum1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> recode = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (recode.containsKey(complement)) {

                int[] res = {i , recode.get(complement)};
                return res;
            }
            recode.put(nums[i], i);
        }
        return null;
    }
}
