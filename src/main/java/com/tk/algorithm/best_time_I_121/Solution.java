package com.tk.algorithm.best_time_I_121;

public class Solution {
    public int maxProfit1(int[] prices) {

        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }




    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
