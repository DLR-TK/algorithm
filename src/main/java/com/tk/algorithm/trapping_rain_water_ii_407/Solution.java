package com.tk.algorithm.trapping_rain_water_ii_407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    /**
     *
     *
     *          小根堆数据类型 （num, row, col）   max -> 系统最小
     *          (1)将边缘数放入小根堆中（heap）
     *          (2)弹出堆顶 num
     *          (3)max - num > 0    water += max - num
     *          将num 的上下左右放入小根堆 利用boolean[][] 数组防止重复放入
     *
     * @param heightMap 高度二维数组
     * @return 雨水值
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null ||
                heightMap.length == 0 ||
                heightMap[0] == null ||
                heightMap[0].length == 0) {
            return 0;
        }

        int N = heightMap.length;
        int M = heightMap[0].length;

        //防止重复放入
        boolean[][] recode = new boolean[N][M];

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        //放入四条边
        // (o o o) o
        //  o o o  o
        //  o o o  o
        //  o (o o o)

        // o o o
        //   ->
        for (int row = 0; row < N - 1; row++) {
            recode[row][0] = true;
            queue.add(new Node(heightMap[row][0], row, 0));
        }
        // o
        // o |
        // o v
        for (int col = 0; col < M - 1; col++) {
            recode[N -1][col] = true;
            queue.add(new Node(heightMap[N - 1][col], N - 1, col));
        }
        // o o o
        //   <-
        for (int row = N - 1; row > 0 ; row--) {
            recode[row][M - 1] = true;
            queue.add(new Node(heightMap[row][M - 1], row, M - 1));
        }
        // o ^
        // o |
        // o
        for (int col = M - 1; col > 0; col--) {
            recode[0][col] = true;
            queue.add(new Node(heightMap[0][col], 0, col));
        }

        int res = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = Math.max(max, node.value);
            int r = node.row;
            int c = node.col;
            if (r > 0 && !recode[r - 1][c]) {
                res += Math.max(max - heightMap[r - 1][c], 0);
                recode[r - 1][c] = true;
                queue.add(new Node(heightMap[r - 1][c], r - 1, c));
            }
            if (c > 0 && !recode[r][c - 1]) {
                res += Math.max(max - heightMap[r][c - 1], 0);
                recode[r][c - 1] = true;
                queue.add(new Node(heightMap[r][c - 1], r, c - 1));
            }
            if (r < N - 1 && !recode[r + 1][c]) {
                res += Math.max(max - heightMap[r + 1][c], 0);
                recode[r + 1][c] = true;
                queue.add(new Node(heightMap[r + 1][c], r + 1, c));
            }
            if (c < M - 1 && !recode[r][c + 1]) {
                res += Math.max(max - heightMap[r][c + 1], 0);
                recode[r][c + 1] = true;
                queue.add(new Node(heightMap[r][c + 1], r, c + 1));
            }
        }
        return res;
    }

    public static class Node {
        public int value;
        public int row;
        public int col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
