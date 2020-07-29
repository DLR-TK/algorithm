package com.tk.algorithm.reverse_words_in_a_string_151;


public class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim();
//        char[] chars = s.toCharArray();
        int i = s.length() - 1, j = s.length();

        while (i > 0) {
            if (s.charAt(i) == ' ') {
                res.append(s, i + 1, j).append(' ');
                while (s.charAt(i) == ' ') {
                    i--;
                }
                j = i + 1;
            }
            i--;
        }
        return res.append(s, 0, j).toString();
    }
}
