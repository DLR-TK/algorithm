package com.tk.algorithm.rotting_ranges_994;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private int m,n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;
        int time = 0;

        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Position(i, j, time));
                }
            }
        }
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            time = position.time;
            for (int i = 0; i < 4; i++) {
                int newX = position.x + d[i][0];
                int newY = position.y + d[i][1];
                if (inArea(newX,newY) && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new Position(newX, newY, position.time + 1));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private class Position {
        int x, y, time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int num = solution.orangesRotting(grid);
        System.out.println(num);
    }
}
