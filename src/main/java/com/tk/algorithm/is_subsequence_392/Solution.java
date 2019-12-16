package com.tk.algorithm.is_subsequence_392;

public class Solution {

    public boolean isSubsequence(String s, String t) {

        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
                if (si == s.length())
                    return true;
            }else {
                ti++;
            }
        }
        return si == s.length();
    }


    public boolean isSubsequence2(String s, String t) {
            int index = -1;
            for (char c : s.toCharArray()){
                index = t.indexOf(c, index+1);
                if (index == -1) return false;
            }
            return true;
    }

}
