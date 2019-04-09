package com.Solution.dynamic_programming;

/**
 * 题目：现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 思路：这是一个二维的01背包问题，对于每个字符，需要统计0和1的个数，所以需要两个背包，思路同分割等和子集的动态规划解法。
 */
public class findMaxForm_474_1和0字符构成最多的字符串 {
    public int findMaxForm(String[] strs, int m, int n) {
        int zeros=0;
        int ones=0;
        int[][] dp=new int[m+1][n+1];
        for(String s:strs)
        {
            for(char c:s.toCharArray())
            {
                if(c=='0')
                    zeros++;
                else
                    ones++;
            }
            for (int i = m; i>=zeros ; i--) {
                for (int j = n; j >=ones ; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
