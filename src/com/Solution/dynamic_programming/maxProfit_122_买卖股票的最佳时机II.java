package com.Solution.dynamic_programming;

/**
 * 题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 思路：动态规划
 */
public class maxProfit_122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int sell=0;
        int buy=-prices[0];
        for (int i = 1; i <prices.length ; i++) {
            buy=Math.max(buy,sell-prices[i]);
            sell=Math.max(sell,buy+prices[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] test={4,2,1,3,5};
        int ans=new maxProfit_122_买卖股票的最佳时机II().maxProfit(test);
        System.out.println(ans);
    }
}
