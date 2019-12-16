package com.tk.algorithm.assign_cookies_455;

import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int gi = g.length - 1, si = s.length - 1;
        while (gi >= 0 && si >= 0 ) {

            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            }else {
                gi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {1,3,2,5,4};
        Arrays.sort(n);

        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
        }
    }
}
