package com.tk.algorithm.range_of_motion_of_robot_1531;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * BFS 广度优先搜索
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {

        boolean[][] recode = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 0});
        int res = 0;

        while (queue.size() > 0) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], xSum = curr[2], ySum = curr[3];
            if (x < 0 || x >= m || y < 0 || y >= n || xSum + ySum > k || recode[x][y]) {
                continue;
            }
            recode[x][y] = true;
            res++;

            queue.add(new int[] {x + 1, y, (x + 1) % 10 != 0 ? xSum + 1 : xSum - 8, ySum});
            queue.add(new int[] {x, y + 1, xSum, (y + 1) % 10 != 0 ? ySum + 1 : ySum - 8});
        }


        return res;
    }

    /**
     * DFS 深度优先搜索
     */
    int m, n, k;
    boolean[][] recode;
    public int movingCount2(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.recode = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int x, int y, int xSum, int ySum) {
        if(x < 0 || x >= m || y < 0 || y >= n || k < xSum + ySum || recode[x][y])
            return 0;
        recode[x][y] = true;
        return 1 + dfs(x + 1, y, (x + 1) % 10 != 0 ? xSum + 1 : xSum - 8, ySum)
                + dfs(x, y + 1, xSum, (y + 1) % 10 != 0 ? ySum + 1 : ySum - 8);
    }
}
