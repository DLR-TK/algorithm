package com.tk.algorithm.perfect_squares_279;

import javafx.util.Pair;

import java.util.*;

@SuppressWarnings("all")
public class Solution {

    public int numSquares(int n) {

        if (n == 0) {
            return 0;
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            int num = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.poll();

            for (int i = 1; ; i++) {
                int a = num - (i * i);
                if (a < 0)
                    break;

                if (a == 0)
                    return step + 1;

                if (!visited[i]) {
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalStateException("error: Expected positive integer");
    }

    public static void main(String[] args) {

        Random random = new Random();

        /**
         * PriorityQueue 默认最小堆  15 43 45 50 53 55 75 79 98 99
         */
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < 10; i++) {
//            int num = random.nextInt(100);
//            queue.add(num);
//            System.out.println("insert " + num + " in PriorityQueue");
//        }
//
//        while (!queue.isEmpty()) {
//            System.out.print(queue.peek() + " ");
//            queue.poll();
//        }
//
//        System.out.println();

        /**
         * 最大堆
         * (1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
         * (2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
         * 95 80 71 57 51 46 34 33 27 14
         */
//        Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for (int i = 0; i < 10; i++) {
//            int num = random.nextInt(100);
//            queue2.add(num);
//            System.out.println("insert " + num + " in PriorityQueue");
//        }
//
//        while (!queue2.isEmpty()) {
//            System.out.print(queue2.peek() + " ");
//            queue2.poll();
//        }
//
//        System.out.println();

        /**
         * 重写比较器
         * 按个位数升序排列 (o1 % 10) - (o2 % 10)
         * 21 93 24 94 85 66 67 8 8 88
         */
        Queue<Integer> queue3= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 10) - (o2 % 10);
            }
        });
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            queue3.add(num);
            System.out.println("insert " + num + " in PriorityQueue");
        }

        while (!queue3.isEmpty()) {
            System.out.print(queue3.peek() + " ");
            queue3.poll();
        }
    }
}
