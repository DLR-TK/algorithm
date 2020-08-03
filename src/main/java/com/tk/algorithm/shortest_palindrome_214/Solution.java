package com.tk.algorithm.shortest_palindrome_214;

@SuppressWarnings("all")
public class Solution {

    public static String shortestPalindrome(String s) {
        return manacher(s);
    }

    public static String manacher(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] str = manacherString(s);
        //回文半径大小  半径 - 1 回文串长度
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int maxEnd = Integer.MIN_VALUE;

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
            if (R == str.length) {
                maxEnd = pArr[i];
                break;
            }
        }

        StringBuilder addStr = new StringBuilder();
        StringBuilder res = new StringBuilder(s);
        int index = s.length() - maxEnd - 1;
        for (int i = 0; i < s.length() - maxEnd + 1; i++) {
            addStr.append(str[i * 2 + 1]);
        }
        addStr.reverse();
        res.reverse().append(addStr);
        return res.toString();
    }

    public static char[] manacherString(String s) {

        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (char c : chars) {
            builder.append(c).append("#");
        }
        return builder.reverse().toString().toCharArray();
    }

    public static void main(String[] args) {
        String s1 = "aacecaaa";
        String s2 = "abcd";
        System.out.println(shortestPalindrome(s2));
    }
}
