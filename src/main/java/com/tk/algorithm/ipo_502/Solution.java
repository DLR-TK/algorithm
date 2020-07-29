package com.tk.algorithm.ipo_502;

import java.util.PriorityQueue;

public class Solution {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Profits == null || Capital == null) {
            return 0;
        }

        //按成本排列，最少的放在堆顶，小根堆
        PriorityQueue<Item> capitalQueue = new PriorityQueue<>((o1, o2) -> o1.capital - o2.capital);
        //按利润排列，最高的放在堆顶，大根堆
        PriorityQueue<Item> profitsQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);

        //将数组加入堆中
        for (int i = 0; i < Profits.length; i++) {
            capitalQueue.add(new Item(Capital[i], Profits[i]));
        }

        //最多完成K个项目
        for (int i = 0; i < k; i++) {
            //弹出所有成本低于当前资本的项目加入大根堆
            while (!capitalQueue.isEmpty()) {
                if (capitalQueue.peek().capital > W) {
                    break;
                }
                profitsQueue.add(capitalQueue.poll());
            }

            //选择利润最高的项目，资金 = 当前资金 + 利润
            if (!profitsQueue.isEmpty()) {
                W += profitsQueue.poll().profit;
            }
        }
        return W;
    }

    //项目类
    public class Item {
        int capital;
        int profit;

        public Item(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}
