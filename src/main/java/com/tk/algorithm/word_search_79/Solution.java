package com.tk.algorithm.word_search_79;

public class Solution {

    private int[][] d= {{-1,0},{0,1},{1,0},{0,-1}};
    private int m,n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        assert (m > 0);
        n = board[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }


    /**
     * 从board[startX,startY]开始，寻找word[index...word.length()]
     * @param board  二维数组
     * @param word   单词
     * @param index  word第index个元素
     * @param startX x轴起点
     * @param startY y轴起点
     * @return
     */
    private boolean searchWord(char[][] board, String word, int index,
                               int startX,int startY) {

        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        //从board[startX][startY]出发向四个方向寻找
        if (board[startX][startY] == word.charAt(index)) {

            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, index + 1, newX, newY))
                    return true;
            }
            visited[startX][startY] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
