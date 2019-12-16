package com.tk.algorithm.minimum_subarray_209;

public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1; //nums[l...r]为滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (sum < s && r+1 < nums.length) {
                r++;
                sum += nums[r];
            }else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                if (res > (r-l+1)) {
                    res = r-l+1;
                }
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
