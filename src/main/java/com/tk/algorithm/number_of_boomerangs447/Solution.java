package com.tk.algorithm.number_of_boomerangs447;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        for (int i = 0; i < points.length; i++) {

            Map<Double, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    double distance = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    Integer freq = record.get(distance);
                    if (freq == null) {
                        record.put(distance, 1);
                    }else {
                        record.put(distance, ++freq);
                    }
                }
            }

            Iterator iterator = record.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Double, Integer> entry = (Map.Entry) iterator.next();

                if (entry.getValue() != null) {
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }

        return res;
    }

}
