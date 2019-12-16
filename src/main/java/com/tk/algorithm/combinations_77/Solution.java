package com.tk.algorithm.combinations_77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        Stack<Integer> c = new Stack<>();
        generateCombinations(n, k, 1, c);
        return res;
    }

    private void generateCombinations(int n, int k, int start, Stack<Integer> c) {

        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        /**
         * 还有k - c.size()个空位，所以[i...n]中至少要有k - c.size()个元素
         * i最多为 n - (k - c.size()) + 1
         */
        for (int i = start; i <= n - (k - c.size()) + 1 ; i++) {
            c.push(i);
            generateCombinations(n, k, i + 1, c);
            c.pop();
        }
        return;
    }
}
