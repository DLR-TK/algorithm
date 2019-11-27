package com.tk.algorithm.longest_substring3;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] frequency = new int[256];
        int l = 0, r = -1; //nums[l...r]为滑动窗口
        int longest = 0;

        while (l < s.length()) {

            if (r + 1 < s.length() && frequency[s.charAt(r+1)] == 0) {
                r++;
                frequency[s.charAt(r)] ++;
            }else {
                frequency[s.charAt(l)] --;
                l++;
            }

            if (longest < (r-l+1)) {
                longest = r-l+1;
            }
        }
        return longest;
    }
}
