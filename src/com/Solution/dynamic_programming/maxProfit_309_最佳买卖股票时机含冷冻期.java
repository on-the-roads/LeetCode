package com.Solution.dynamic_programming;

/**
 * 题目：给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 思路：动态规划
 */
public class maxProfit_309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int[] sell=new int[prices.length];
        int[] buy=new int[prices.length];
        int[] cooldown=new int[prices.length];
        sell[0]=0;//第一天
        buy[0]=-prices[0];//第一天
        cooldown[0]=0;//第一天
        for (int i = 1; i <prices.length ; i++) {
            cooldown[i]=sell[i-1];//若第i天是冷冻期，则第i-1天一定是卖出
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);//若考虑第i天卖出
            buy[i]=Math.max(cooldown[i-1]-prices[i],buy[i-1]);//若考虑第i天买入
        }
        return Math.max(sell[prices.length-1],cooldown[prices.length-1]);//要想获得最大利润，最后一天一定是冷冻期或者卖出状态。
    }

    public static void main(String[] args) {
        int[] test={2,2,2};
        int ans=new  maxProfit_309_最佳买卖股票时机含冷冻期().maxProfit(test);
        System.out.println(ans);
    }
}
