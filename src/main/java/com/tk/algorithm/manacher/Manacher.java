package com.tk.algorithm.manacher;

@SuppressWarnings("all")
public class Manacher {

    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = manacherString(s);

        //回文半径大小  半径 - 1 回文串长度
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;

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
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
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

    public static char[] manacherString2(String s) {

        char[] charArray = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length ; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArray[index++];
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(manacherString(s));
        System.out.println(manacherString2(s));
    }
}
