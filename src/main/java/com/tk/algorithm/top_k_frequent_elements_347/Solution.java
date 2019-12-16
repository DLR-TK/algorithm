package com.tk.algorithm.top_k_frequent_elements_347;

import javafx.util.Pair;

import java.util.*;

public class Solution {

    /**
     * 时间复杂度 O(nlogk)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {

        assert (k > 0);

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Integer freq = record.get(nums[i]);
            if (freq == null) {
                record.put(nums[i], 1);
            }else {
                record.put(nums[i], ++freq);
            }
        }

        assert (k <=  nums.length);

        /**
         * 优先队列 （频率，元素） 最小堆
         */
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            if (queue.size() == k) {
                if (entry.getValue() > queue.peek().getKey()) {
                    queue.poll();
                    queue.add(new Pair<>(entry.getValue(), entry.getKey()));
                }
            }else {
                queue.add(new Pair<>(entry.getValue(), entry.getKey()));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.peek().getValue());
            queue.poll();
        }
        Collections.reverse(res);
        return res;
    }


    public List<Integer> topKFrequent2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove());
        }
        return res;
    }
}
