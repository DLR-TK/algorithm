package com.tk.algorithm.intersection350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> recode = new HashMap<>();
        for (int num : nums1) {
            Integer freq = recode.get(num);
            if (freq == null) {
                recode.put(num, 1);
            }else {
                recode.put(num, ++freq);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            Integer freq = recode.get(num);
            if (freq != null && freq > 0) {
                result.add(num);
                recode.put(num, --freq);
            }
        }

        int[] nums = new int[result.size()];
        int i = 0;
        for (int res : result) {
            nums[i++] = res;
        }
        return nums;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(map.get(42)); //null Java中默认值为null
    }
}
