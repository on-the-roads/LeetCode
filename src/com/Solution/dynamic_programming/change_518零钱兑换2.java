package com.Solution.dynamic_programming;

/**
 * 题目：给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 思路:
 * 思路1：动态规划,思路由零钱兑换I而来，设置一个数组dp[coins.length+1][amount+1]，dp[i][j]表示硬币面额为coins[0..i-1]的硬币能够成总金额为j的硬币组合数
 * 状态转移方程：dp[i][j]=dp[i-1][j]+dp[i-1][j-2*coins[i-1]]+dp[i-1][j-3*coins[i-1]]+dp[i-1][j-4*coins[i-1]]+...直到j-k*coins[i-1]小于0
 *
 * 思路2：动态规划，用一维数组解决问题，与分割等和子集的思路有点相像，只不过此题是从前往后，先计算dp[i-coin]后计算dp[i],而分割等和子集的题是从后往前
 */
public class change_518零钱兑换2 {
//    思路1
//    public int change(int amount, int[] coins) {
//        if(amount<=0||coins==null||coins.length==0)
//            return 0;
//        int[][] dp=new int[coins.length+1][amount+1];//dp[i][j]表示硬币面额为coins[0..i-1]的硬币能够成总金额为j的硬币组合数
//        for (int col = 1; col <=amount ; col++) {
//            dp[0][col]=0;//0元不能组合成大于1的金钱
//        }
//        for (int row = 0; row <= coins.length ; row++) {
//            dp[row][0]=1;//任何面额的硬币构成总金额为0的组合数均为1
//        }
//        for (int row = 1; row <coins.length+1 ; row++) {
//            for (int col = 1; col < amount+1; col++) {
//                int sum=0;
//                int temp=col;
//                while(temp>=0) {
//                    sum += dp[row - 1][temp];
//                    temp-=coins[row-1];
//                }
//                dp[row][col]=sum;
//            }
//        }
//        return dp[coins.length][amount];
//    }

//    思路2
    public int change(int amount, int[] coins){
        if(amount<=0||coins==null||coins.length==0)
            return 0;
        int[] dp=new int[amount+1];
        dp[0]=1;//构成总金额为0的组合数均为1
        for(int coin:coins)
            for (int i = coin; i <amount+1 ; i++) {
                dp[i]+=dp[i-coin];
            }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount=10;
        int[] coins={9};
        int ans=new change_518零钱兑换2().change(amount,coins);
        System.out.println(ans);
    }
}
