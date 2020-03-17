package com.tk.algorithm.max_area_of_island_695;

@SuppressWarnings("all")
public class Solution {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean[][] recode;
    private int m,n;
    private int maxArea,area;

    public int maxAreaOfIsland(int[][] grid) {

        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;

        maxArea = 0;
        recode = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !recode[i][j]) {
                    area = 0;
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {

        recode[x][y] = true;
        area ++;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (isArea(newX, newY) && !recode[newX][newY] && grid[newX][newY] == 1) {
                dfs(grid , newX, newY);
            }
        }

        return area;
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >=0 && y < n;
    }

}
