package com.Solution.Greedy;

/**
 * 题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 思路：贪心算法  一个变量记录当前最小的买入价格，一个变量记录当前最大的利润，从前往后遍历股票价格
 */
public class maxProfit_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarmin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
//            soFarmin=Math.min(soFarmin,prices[i]);
//            maxProfit=Math.max(maxProfit,prices[i]-soFarmin);

            //对上述两行代码的优化
            if (soFarmin > prices[i]) soFarmin = prices[i];//将当前价格设为最低价格后就不用比较当前卖出的利润和之前的最大利润的关系了，因为当前卖出的利润为0
            else
                maxProfit = Math.max(maxProfit, prices[i] - soFarmin);
        }
        return maxProfit;
    }
}
