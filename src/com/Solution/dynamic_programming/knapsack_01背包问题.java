package com.Solution.dynamic_programming;

/**
 * 题目：01背包问题，有一个容量为N的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积v和价值v。
 */
public class knapsack_01背包问题 {
    public int knapsack(int N, int capcity, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][capcity + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i-1];
            int v = values[i-1];
            for (int j = 1; j <= capcity; j++) {
                if (j < w)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }
        return dp[N][capcity];
    }


    public static void main(String[] args) {
        int[] weights={ 1 , 2 , 3 , 4 , 5};
        int[] values={2 , 3 , 4 , 5 , 6};
        int N=5;
        int capcity=2;
        int ans=new knapsack_01背包问题().knapsack(N,capcity,weights,values);
        System.out.println(ans);
    }
}
