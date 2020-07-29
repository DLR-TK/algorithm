package com.tk.algorithm.generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();

        dfs("", n, n, res);
        return res;
    }

    private void dfs(String str, int left, int right, List<String> res) {

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }
}
