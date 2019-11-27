package com.tk.algorithm.longest_common_subsequence1143;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[m][n];
    }

    public static void main(String[] args) {

    }
}
