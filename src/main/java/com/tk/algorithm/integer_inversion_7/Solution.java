package com.tk.algorithm.integer_inversion_7;

public class Solution {


    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int i = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && i > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && i < -8) {
                return 0;
            }
            res = res * 10 + i;
            x /= 10;
        }
        return res;
    }


    /**
     * 2147483647
     * -2147483648
     */
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(1234567899));
    }
}
