package com.tk.algorithm.remove_linked203;

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算[l...n)区间内所有数字的和
     * @param arr 数组
     * @param l 左边界
     */
    private static int sum(int[] arr, int l) {

        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
