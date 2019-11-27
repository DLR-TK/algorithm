package com.tk.algorithm.house_robber198;

import java.util.Arrays;

public class Solution {

    private int[] memo;
    private boolean[] recode;

    /**
     * 记忆搜索 较快
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        memo = new int[nums.length];
        recode = new boolean[nums.length];
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {

        if (index >= nums.length)
            return 0;

        if (recode[index])
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        recode[index] = true;
        return res;
    }

    /**
     * 动态规划  较慢
     * 考虑偷取[x...n-1]范围里的房子  (对状态定义)
     * memo[i] 表示考虑偷取[i...n-1]的最大收益
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {

        int n = nums.length;

        if (n == 0)
            return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[n - 1] = nums[n - 1];
        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0 ));
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.memo = new int[10];
        Arrays.fill(solution.memo, -1); //为数组初始化值为 -1
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.memo[i]);
        }
    }
}
