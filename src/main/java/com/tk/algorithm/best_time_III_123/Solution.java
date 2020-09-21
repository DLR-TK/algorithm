package com.tk.algorithm.best_time_III_123;

@SuppressWarnings("all")
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int N = prices.length;
        int[][] dp = new int[N][3];
        int res = 0;
        for (int j = 1; j <= 2; j++) {
            //dp[0][j] = 0
            int mult = dp[0][j - 1] - prices[0];
            for (int i = 1; i < N; i++) {
                mult = Math.max(mult, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(dp[i - 1][j], mult + prices[i]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }



    public int maxProfit1(int[] prices) {
        return maxProfitIV(2, prices);
    }

    //股票IV解法
    public static int maxProfitIV(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int N = prices.length;
        //可进行任意次交易 与股票II解法相同
        if (k >= N / 2) {
            return maxProfitII(prices);
        }

        int[][] dp = new int[N][k + 1];
        int res = 0;
        for (int j = 1; j <= k; j++) {
            //dp[0][j] = 0
            int mult = dp[0][j - 1] - prices[0];
            for (int i = 1; i < N; i++) {
                mult = Math.max(mult, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(dp[i - 1][j], mult + prices[i]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    //股票II解法
    public static int maxProfitII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
