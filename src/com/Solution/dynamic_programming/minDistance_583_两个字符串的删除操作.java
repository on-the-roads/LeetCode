package com.Solution.dynamic_programming;

/**
 * 题目：给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 思路：动态规划，dp[i][j]表示word1的前i个字符与word2的前j个字符相等所需要的最小操作数
 */
public class minDistance_583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        //初始化边界条件
        for (int i = 0; i <m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <n; i++) {
            dp[0][i]=i;
        }
        //状态转移方程
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int ans=new minDistance_583_两个字符串的删除操作().minDistance("sea","eat");
        System.out.println(ans);
    }
}
