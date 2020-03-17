package com.tk.algorithm.best_time_121;

public class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }
}
