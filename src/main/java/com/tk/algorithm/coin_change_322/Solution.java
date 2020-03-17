package com.tk.algorithm.coin_change_322;

import java.util.Arrays;

public class Solution {
//    public int coinChange(int[] coins, int amount) {
//
//
//        int[] memo = new int[amount + 1];
//        memo[0] = 0;
//
//        for(int i = 1; i <= amount; i++){
//            int min = Integer.MAX_VALUE;
//            for(int j = 0; j < coins.length; j++){
//                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
//                    min = Math.min(min, memo[i - coins[j]] + 1);
//                }
//            }
//            memo[i] = min;
//        }
//        return  memo[amount] ==  Integer.MAX_VALUE ? -1 : memo[amount];
//    }

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length-1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChange(int index, int[] coins, int count, int amount) {
        if (amount == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (index < 0) {
            return;
        }

        int n = amount / coins[index];
        for (int i=n; i>=0 && count+i<ans; i--) {
            coinChange(index-1, coins, count+i, amount-i*coins[index]);
        }
    }
}
