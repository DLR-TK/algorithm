package com.tk.algorithm.greatest_common_divisor_of_strings_1071;

public class Solution {

//    public String gcdOfStrings(String str1, String str2) {
//
//        if (!(str1 + str2).equals(str2 + str1)) {
//            return "";
//        }
//
//        return str1.substring(0, gcd(str1.length(), str2.length()));
//    }
//
//    private int gcd(int l1,int l2) {
//        return l2 == 0 ? l1 : gcd(l2 , l1 % l2);
//    }

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int res = str1.length();
        int length = str2.length();
        while (length != 0) {
            int n = res;
            res = length;
            length = n % length;
        }

        return str1.substring(0,res);
    }
}
