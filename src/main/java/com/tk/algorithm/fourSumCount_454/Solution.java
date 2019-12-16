package com.tk.algorithm.fourSumCount_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer value = record.get(C[i] + D[j]);
                if (value == null) {
                    record.put(C[i] + D[j], 1);
                }else {
                    record.put(C[i] + D[j], ++value);
                }
            }
        }

        int freq = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (record.containsKey(0 - A[i] - B[j])) {
                    freq += record.get(0 - A[i] - B[j]);
                }
            }
        }
        return freq;
    }
}
