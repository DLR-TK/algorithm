package com.tk.algorithm.distribute_candies_to_people_1103;

public class Solution {

    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        int candie = 1;
        int i = 0;

        while (candies > 0) {
            if (candies - candie > 0) {
                res[i] += candie;
                candies -= candie;
                candie += 1;
            } else {
                res[i] += candies;
            }
            i++;
            if (i == num_people) {
                i = 0;
            }
        }
        return res;
    }
}
