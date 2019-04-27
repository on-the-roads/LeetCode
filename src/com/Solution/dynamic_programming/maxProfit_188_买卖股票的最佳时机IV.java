package com.Solution.dynamic_programming;

import java.util.Arrays;

/**
 * 题目：给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 思路：动态规划。对k进行判断：
 * 若k*2>len，退化为问题122
 * 否则退化为次数不超过k次的问题123
 */
public class maxProfit_188_买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        if(k<=0||prices==null||prices.length==0)
            return 0;
        int len=prices.length;
        if(k*2>len)//退化为普通的股票问题，用贪心算法即可求解
        {
            int maxProfit=0;
            for (int i = 1; i <len ; i++) {
                if(prices[i]>prices[i-1])
                    maxProfit+=prices[i]-prices[i-1];
            }
            return maxProfit;
        }

        int[] buy=new int[len];
        int[] sell=new int[len];
        Arrays.fill(buy,Integer.MIN_VALUE);
        for(int curprice:prices)
            for (int i = 1; i <=k; i++) {//k次股票交易
                buy[i]=Math.max(buy[i],sell[i-1]-curprice);
                sell[i]=Math.max(sell[i],buy[i]+curprice);
            }
        return sell[k];
    }

    public static void main(String[] args) {
        int test[]={3,2,6,5,0,3};
        int k=2;
        int ans=new maxProfit_188_买卖股票的最佳时机IV().maxProfit(k,test);
        System.out.println(ans);
    }
}
