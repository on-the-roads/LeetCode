package com.Solution.dynamic_programming;

import java.util.Arrays;

/**
 * 题目：给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 思路：因为硬币的数量可以重复使用，所以这是一个完全背包问题，设置一个dp[i]表示组成金钱总数为i所需的最小硬币数量。
 * 则状态方程为dp[i]=min{dp[i],dp[i-coins[j]]+1};  初始时设置dp[0]=0,dp[1..amount]=amount+1;
 */
public class coinChange_322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0||amount<=0)
            return -1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }

        }
        return dp[amount]>amount?-1:dp[amount];//如果dp[amount]>amount则说明用coins的金钱不能组成总数为amount的钱
    }

    public static void main(String[] args) {
        int[] coins={2};
        int amount=3;
        int ans=new coinChange_322零钱兑换().coinChange(coins,amount);
        System.out.println(ans);
    }
}
