package com.tk.algorithm.life_game_289;

public class Solution {

    public void gameOfLife(int[][] board) {

        int[] displace = {0, 1, -1};

        int m = board.length;
        int n = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int survivals = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(displace[i] == 0 && displace[j] == 0)) {
                            // 相邻位置的坐标
                            int newX = (x + displace[i]);
                            int newY = (y + displace[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((newX < m && newX >= 0) && (newY < n && newY >= 0) && (Math.abs(board[newX][newY]) == 1)) {
                                survivals += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[x][y] == 1) && (survivals < 2 || survivals > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[x][y] = -1;
                }
                // 规则 4
                if (board[x][y] == 0 && survivals == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[x][y] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] > 0) {
                    board[x][y] = 1;
                } else {
                    board[x][y] = 0;
                }
            }
        }
    }
}
