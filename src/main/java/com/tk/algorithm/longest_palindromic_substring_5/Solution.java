package com.tk.algorithm.longest_palindromic_substring_5;


/**
 * 动态规划
 * 状态转移方程 (r - l <= 2 or recode[l + 1, r - 1])
 * l + 1 < r - 1 至少存在两个数 -> 不存在两个数 l + 1 >= r - 1 -> r - l <= 2
 * 如果 s[l] == s[r] 只要 l + 1 -> r - 1 为回文串 l -> r 必为回文串
  */
@SuppressWarnings("all")
public class Solution {

    //动态规划
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

    public static String longestPalindrome2(String s) {
        return manacher(s);
    }


    public static String manacher(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] str = manacherString(s);

        //回文半径大小  半径 - 1 回文串长度
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < str.length; i++) {
            //i位置至少包含多少元素
            //1. i在R外 1  R < i
            //2. i在R内 (R - i, pArr[2 * C - i])   R > i   -- i` + i = 2c => i` = 2c - i
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //判断左右边界
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (max < pArr[i]) {
                max = pArr[i];
                cur = i;
            }
        }
        char[] res = new char[max - 1];
        int index = cur - pArr[cur] + 2;
        for (int i = 0; i < max - 1; i++) {
            res[i] = str[index];
            index += 2;
        }
        return new String(res);
    }

    public static char[] manacherString(String s) {

        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (char c : chars) {
            builder.append(c).append("#");
        }
        return builder.toString().toCharArray();
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }
}
