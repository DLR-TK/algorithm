package com.tk.algorithm.best_time_IV_188;

@SuppressWarnings("all")
public class Solution {

    /**
     *          (1) k >= prices.length / 2 可进行任意次交易 与股票II解法相同
     *          (2) dp[i][j]      prices[i]股票数组    j <= k次数
     *              1) i位置不参与 dp[i-1][j]
     *              2) i位置参与 => i位置作为最后一次卖出时机 => 寻找最后一次购入时机
     *                 mult(i) : max {
     *                      dp[i][j-1] - prices[i],
     *                      mult(i-1) : max{
     *                          dp[i-1][j-1] - prices[i-1],
     *                          dp[i-2][j-1] - prices[i-2],
     *                          dp[i-3][j-1] - prices[i-3],
     *                          ...
     *                          dp[0][j-1] - prices[0]
     *                      }
     *                  }  + prices[i]
     *              res : max(dp[i-1][j], mult(i) + prices[i])
     * @param k 交易次数
     * @param prices 股票数组
     * @return  最大利润
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int N = prices.length;
        //可进行任意次交易 与股票II解法相同
        if (k >= N / 2) {
            return maxProfit(prices);
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
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
