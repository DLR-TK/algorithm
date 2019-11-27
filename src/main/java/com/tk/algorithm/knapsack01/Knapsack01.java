package com.tk.algorithm.knapsack01;

import java.util.Arrays;

/**
 * 01背包问题
 * 记忆搜索 动态规划
 */
@SuppressWarnings("all")
public class Knapsack01 {

    private int[][] memo;

    /**
     * 时间复杂度 O(n*c)
     * 空间复杂度 O(n*c)
     * 记忆搜索
     * @param w 物品重量
     * @param v 物品价值
     * @param C 背包容量
     * @return
     */
    public int knapsack01(int[] w, int[] v,int C) {

        int n = w.length;
        memo = new int[n][C+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValue(w , v, n - 1, C);
    }

    /**
     * 用[0...index]的物品，填充容积为c的背包的最大价值
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        memo[index][c] = res;

        return res;
    }


    /**
     * 时间复杂度 O(n*c)
     * 空间复杂度 O(n*c) 优化 -> O(c) 2*c
     * 动态规划
     * @param w 物品重量
     * @param v 物品价值
     * @param C 背包容量
     * @return
     */
    public int knapsack02(int[] w, int[] v,int C) {

        assert (w.length == v.length);

        int n = w.length;
        if (n == 0)
            return 0;

        memo = new int[2][C+1];         // memo = new int[n][C+1]; 优化前
        for (int i = 0; i < 2; i++) {   // int i = 0; i < n; i++
            Arrays.fill(memo[i], -1);
        }

        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i%2][j] = memo[(i-1)%2][j];   // memo[i][j] = memo[i-1][j];
                if (j >= w[i])
                    memo[i%2][j] = Math.max(memo[i%2][j], v[i] + memo[(i-1)%2][j-w[i]]); //memo[i][j] = Math.max(memo[i][j], v[i] + memo[i-1][j-w[i]]);
            }
        }
        return memo[(n-1)%2][C]; // memo[n-1][C]
    }


    public int knapsack03(int[] w, int[] v,int C) {

        assert (w.length == v.length);

        int n = w.length;
        if (n == 0)
            return 0;

        int[] memo = new int[C+1];
            Arrays.fill(memo, -1);


        for (int j = 0; j <= C; j++) {
            memo[j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i] ; j--) {
                    memo[j] = Math.max(memo[j], v[i] + memo[j-w[i]]);
            }
        }
        return memo[C];
    }


    public static void main(String[] args) {

//        int[][] memo = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j <5 ; j++) {
//                System.out.print(memo[i][j]);
//            }
//            System.out.println();
//        }

        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int c = 5;

        Knapsack01 knapsack01 = new Knapsack01();
        int n = knapsack01.knapsack02(w, v, c);
        System.out.println(n);

        for (int i = 0; i < 2; i++) {  //int i = 0; i < w.length; i++
            for (int j = 0; j <= c ; j++) {
                System.out.print(knapsack01.memo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
