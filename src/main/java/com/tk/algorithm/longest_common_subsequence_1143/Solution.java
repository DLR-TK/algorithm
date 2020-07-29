package com.tk.algorithm.longest_common_subsequence_1143;

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

    public int longestCommonSubsequence2(String text1, String text2) {

        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];


        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], str1[0] == str2[i] ? 1 : 0);
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }

}
