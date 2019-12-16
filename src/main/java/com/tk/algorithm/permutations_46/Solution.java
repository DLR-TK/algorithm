package com.tk.algorithm.permutations_46;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        Stack<Integer> p = new Stack<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    /**
     * 向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
     * @param nums
     * @param index
     * @param p 中保存了一个有index个元素的排列
     */
    private void generatePermutation(int[] nums, int index, Stack<Integer> p) {

        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.push(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.pop();
                used[i] = false;
            }
        }
    }

//    public static void main(String[] args) {
//        boolean[] used = new boolean[10];
//
//        for (int i = 0; i < used.length; i++) {
//            if (!used[i]) {
//                System.out.println("false");;
//            }else {
//                System.out.println("true");
//            }
//        }
//    }
}
