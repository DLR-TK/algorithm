package com.tk.algorithm.move_zeros_283;

import java.util.Vector;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     */
    public void moveZeroes1(int[] nums) {

        Vector<Integer> noZero = new Vector<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                noZero.add(nums[i]);
            }
        }

        for (int i = 0; i < noZero.size(); i++) {
            nums[i] = noZero.get(i);
        }

        for (int i = noZero.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        int k = 0; // nums中，[0...k)的元素均为非0元素

        /**
         * 遍历到第i个元素后，保证[0..i]中所有的非0元素都按顺序保存在[0...k)中,同时[k...i]为0
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
//                    int num = nums[i];
//                    nums[i] = nums[k];
//                    nums[k] = num;
                    nums[i] =nums[i] ^ nums[k];
                    nums[k] =nums[i] ^ nums[k];
                    nums[i] =nums[i] ^ nums[k];
                }
                k++;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};
        Solution solution = new Solution();
        solution.moveZeroes2(nums);
        for (int num:nums) {
            System.out.print(num);
        }
    }
}
