package com.Solution.dynamic_programming;

/**
 * 题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 思路：动态规划，因为只允许完成一笔交易，所以设置两个变量buy和sell,
 * 利用状态转移方程
 * buy=max{buy,-curprice} 记录买入状态时的最低买入价格
 * sell=max{sell,buy+curprice}记录卖出状态的最大利润
 * 要想获得最大利润，最后一定是处于卖出状态。
 */
public class maxProfit_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices==null|| prices.length==0)
            return 0;
        int buy= Integer.MIN_VALUE;
        int sell=0;
        for(int curprice:prices)
        {
            buy=Math.max(buy,-curprice);
            sell=Math.max(sell,buy+curprice);
        }
        return sell;
    }
}
