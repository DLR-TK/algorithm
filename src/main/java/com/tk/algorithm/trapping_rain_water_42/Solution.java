package com.tk.algorithm.trapping_rain_water_42;

public class Solution {

    /**
     * 双指针
     *
     *                 0    1    0    2    1    0    1    3    2    1   2   1
     *             leftMax  L->                                       <-R   rightMax
     *
     *             leftMax 和 rightMax 无法获得雨水(边界)
     *             如果确定了 leftMax，rightMax 即可就出当前位置i可获得的雨水量 max(leftMax, rightMax) - height[i]
     *             例如： 7  ... i ... 9
     *                 leftMax       rightMax     i 位置可获得雨水就为 7 - height[i]
     *                 i = 4                      i 位置可获得雨水就为 7 - 4 = 3
     *                 i = 7                      i 位置可获得雨水就为 7 - 7 = 0
     *                 i = 8                      i 位置可获得雨水就为 7 - 8 = -1 （取0）
     *                 所以i位置可获得的雨水量应为 max( max(leftMax, rightMax) - height[i], 0)
     *
     *             具体情况讨论：
     *             (1) leftMax <= rightMax
     *                  更新左边 L  height[L]可获得的雨水数 max(leftMax - height[L], 0)
     *                  更新leftMax max(leftMax, height[L]) L++指针右移
     *             (1) leftMax >  rightMax
     *                  更新右边 R  height[R]可获得的雨水数 max(rightMax - height[R], 0)
     *                  更新rightMax max(rightMax, height[R]) R--指针左移
     *
     * @param height 高度数组
     * @return 雨水
     */
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int N = height.length;
        int L = 1;
        int R = N - 2;
        int res = 0;

        int leftMax = height[0];
        int rightMax = height[N - 1];

        while (L <= R) {
            if (leftMax <= rightMax) {
                res += Math.max(leftMax - height[L], 0);
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                res += Math.max(rightMax - height[R], 0);
                rightMax = Math.max(rightMax, height[R--]);
            }
        }
        return res;
    }
}
