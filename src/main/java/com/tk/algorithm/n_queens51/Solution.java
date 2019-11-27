package com.tk.algorithm.n_queens51;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<String>> res;
    private boolean[] cor,master,slave;
    private int n;
    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        this.n = n;
        if (n == 0)
            return res;

        cor = new boolean[n];
        slave = new boolean[2*n - 1];
        master = new boolean[2*n - 1];

        Stack<Integer> row = new Stack<>();
        putQueen(0, row);

        return res;
    }

    private void putQueen(int index, Stack<Integer> row) {

        if (index == n) {
            List<String> board = generateBorad(row);
            res.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!cor[i] && !slave[index + i] && !master[index - i + n - 1]) {
                row.push(i);
                cor[i] = true;
                slave[index + i] = true;
                master[index - i + n - 1] = true;
                putQueen(index + 1, row);

                cor[i] = false;
                slave[index + i] = false;
                master[index - i + n - 1] = false;
                row.pop();
            }
        }
    }

    private List<String> generateBorad(Stack<Integer> row) {
        assert (row.size() == n);

        List<String> board = new ArrayList<>();
        for (Integer num : row) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res;
        Solution solution = new Solution();
        res = solution.solveNQueens(n);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
