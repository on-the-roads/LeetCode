package com.Solution.dynamic_programming;

/**
 * 题目：编辑距离给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 思路：动态规划思想，建立一个(m+1)x(n+1)的数组dp，其中dp[i][j]代表str1中0~i-1的子串到str2中的0~j-1的所需编辑次数。
 *  则dp[i][j]的值来源于以下四种情况：（ip：插入一个字符的代价  dp:删除一个字符的代价  rp：替换一个字符的代价）
 *          (1) str1[0..i-1]先变为str1[0..i-2]，再由str1[0..i-2]变为str2[0..j-1],即dp[i][j]=dp+dp[i-1][j];
 *          (2) str1[0..i-1]先变为str2[0..j-2]，再由str2[0..j-2]变为str2[0..j-1],即dp[i][j]=ip+dp[i][j-1];
 *          (3)
 *                  （i）当str1[i-1]==str2[j-1]，只需要将str1[0..i-2]先变为str2[0..j-2]，即dp[i][j]=dp[i-1][j-1];
 *                  （ii）当str1[i-1]!=str2[j-1]，先将str1[i-1]交换为str2[j-1]，再将str1[0..i-2]先变为str2[0..j-2]，即dp[i][j]=rp+dp[i-1][j-1];
 *
 *  dp[i][j]去上述四种情况的最下值。
 */
public class minDistance_72编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int min = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int col = 0; col <= n; col++) {
            dp[0][col] = col;
        }
        for (int row = 0; row <= m; row++) {
            dp[row][0] = row;
        }
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (word1.charAt(row - 1) != word2.charAt(col - 1)) {
                    min = Math.min(Math.min(1 + dp[row - 1][col], 1 + dp[row - 1][col - 1]),1 + dp[row][col-1]);
                }
                else
                    min=Math.min(Math.min(1 + dp[row - 1][col],  dp[row - 1][col - 1]),1 + dp[row][col-1]);
                dp[row][col]=min;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int ans=new minDistance_72编辑距离().minDistance("intention","execution");
        System.out.println(ans);
    }
}
