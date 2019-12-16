package com.tk.algorithm.longest_increasing_subsequence_300;

import java.util.Arrays;

public class Solution {


    /**
     * 时间复杂度 O(n^2)
     * memo[0...i]记录包含i最长升序子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int n =nums.length;
        if (n == 0)
            return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int a = -1;
        int b = -2;
        int c = Math.max(a, b);
        System.out.println(c);
    }
}
