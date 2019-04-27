package com.Solution.dynamic_programming;

/**
 * 题目：给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 思路：动态规划
 */
public class maxProfit_123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int firstBuy=Integer.MIN_VALUE;
        int SecondBuy=Integer.MIN_VALUE;
        int firstSell=0;
        int secondSell=0;
        for(int price:prices)
        {
            firstBuy=Math.max(firstBuy,-price);
            firstSell=Math.max(firstSell,firstBuy+price);
            SecondBuy=Math.max(SecondBuy,firstSell-price);
            secondSell=Math.max(secondSell,SecondBuy+price);
        }
        return secondSell;
    }
}
