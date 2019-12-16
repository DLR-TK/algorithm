package com.tk.algorithm.longest_palindromic_substring_5;


/**
 * 动态规划
 * 状态转移方程 (r - l <= 2 or recode[l + 1, r - 1])
 * l + 1 < r - 1 至少存在两个数 -> 不存在两个数 l + 1 >= r - 1 -> r - l <= 2
 * 如果 s[l] == s[r] 只要 l + 1 -> r - 1 为回文串 l -> r 必为回文串
  */
public class Solution {

    public String longestPalindrome(String s) {

        int len = s.length();

        if (len <= 1) {
            return s;
        }

        int maxStrLen = 1;
        String res = s.substring(0, 1);
        boolean[][] recode = new boolean[len][len];

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || recode[l+1][r-1])) {
                    recode[l][r] = true;
                    if (r - l + 1 > maxStrLen) {
                        maxStrLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }
}
