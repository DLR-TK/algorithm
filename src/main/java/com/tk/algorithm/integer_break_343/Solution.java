package com.tk.algorithm.integer_break_343;

public class Solution {

    private int[] memo;
    private boolean[] recode;

    /**
     * 记忆搜索 自顶向下
     * @param n
     * @return
     */
    public int integerBreak1(int n) {

        memo = new int[n + 1];
        recode = new boolean[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {

        if (n == 1)
            return 1;

        if (recode[n])
            return memo[n];

        int res = 0;
        for (int i = 1; i <= n-1; i++) {
            res = maxThree(res, i * (n-i), i * breakInteger(n - i));
        }
        memo[n] = res;
        recode[n] = true;
        return memo[n];
    }

    private int maxThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak2(int n) {

        memo = new int[n + 1];

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1 ; j++) {
                memo[i] = maxThree(memo[i], j * (i-j), j * memo[i-j]);
            }
        }
        return memo[n];
    }
}
