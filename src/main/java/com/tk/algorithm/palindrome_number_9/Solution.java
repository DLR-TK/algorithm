package com.tk.algorithm.palindrome_number_9;

public class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int newNumber = 0;

        while (x > newNumber) {
            newNumber = newNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == newNumber || x == newNumber / 10;
    }
}
