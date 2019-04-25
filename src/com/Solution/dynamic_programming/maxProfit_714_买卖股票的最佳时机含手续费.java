package com.Solution.dynamic_programming;

/**
 * 题目：给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 *
 * 思路:动态规划
 */
public class maxProfit_714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int sell[]=new int[prices.length];
        int buy[]=new int[prices.length];
        sell[0]=0;
        buy[0]=-prices[0];
        for (int i = 1; i <prices.length ; i++) {
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
        }
        return sell[prices.length-1];//要想获得最大利润，最后一天一定是考虑卖出的状态
    }

    public static void main(String[] args) {
        int[] test={1, 3, 2, 8, 4, 9};
        int fee=2;
        int ans=new maxProfit_714_买卖股票的最佳时机含手续费().maxProfit(test,fee);
        System.out.println(ans);
    }
}
