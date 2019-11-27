package com.tk.algorithm.fib;


public class Fibonacci {

    private int m = 0;
    private int[] memo;
    private boolean[] recode;

    /**
     * 记忆化搜索  自顶向下
     * @param n
     * @return
     */
    public int fib(int n) {

        m++;

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (!recode[n]) {
            memo[n] = fib(n - 1) + fib(n - 2);
            recode[n] = true;
        }
        return memo[n];
    }

    /**
     * 动态规划  自底向上
     * @param n
     * @return
     */
    public int fib2(int n) {


        
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            m++;
        }
        return memo[n];
    }

    public static void main(String[] args) {

        int n = 1000;
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.memo = new int[n + 1];
        fibonacci.recode = new boolean[n + 1];
        long start = System.currentTimeMillis();
        int res = fibonacci.fib2(n);
        long end = System.currentTimeMillis();
        System.out.println(res + " 运行次数: " + fibonacci.m);
        System.out.println((end - start) + "ms");
    }
}
