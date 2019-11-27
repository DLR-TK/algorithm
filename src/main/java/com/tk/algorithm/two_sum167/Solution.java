package com.tk.algorithm.two_sum167;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;
        while (l < r) {

            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1, r + 1};
                return res;
            }else if (numbers[l] + numbers[r] < target) {
                l++;
            }else {
                r--;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(numbers, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
}
