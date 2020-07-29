package com.tk.algorithm.jump_game_55;

public class Solution {

    public boolean canJump(int[] nums) {

        int index = 0; //所能到达的最大位置
        for (int i = 0; i < nums.length; i++) {
            if (i > index) { //位置不可达
                return false;
            }
            index = Math.max(index, i + nums[i]); //目前所能到达的最大位置与当前下标所能到达最大位置，取最大值
            if (index >= nums.length) {
                return true;
            }
        }
        return true;
    }
}
