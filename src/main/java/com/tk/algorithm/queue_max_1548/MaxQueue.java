package com.tk.algorithm.queue_max_1548;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> sort;

    public MaxQueue() {
        queue = new LinkedList<>();
        sort = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        return sort.getFirst();
    }

    public void push_back(int value) {
        while (!sort.isEmpty() && sort.getLast() < value) {
            sort.pollLast();
        }
        sort.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int res = queue.poll();
        if (res == sort.getFirst()) {
            sort.pollFirst();
        }
        return res;
    }
}
