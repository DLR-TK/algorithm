package com.tk.algorithm.valid_palindrome_125;


public class Solution {

    public boolean isPalindrome(String s) {

        if (s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
