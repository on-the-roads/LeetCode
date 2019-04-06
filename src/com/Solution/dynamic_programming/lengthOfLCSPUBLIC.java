package com.Solution.dynamic_programming;

/**
 * 题目：最长公共子序列长度
 * 思路：定义一个数组dp[m][n],m为序列S1的长度，n为序列S2的长度，dp[i][j]表示S1[0..i]和S2[0..j]的最长公共子序列长度
 *
 *dp[i][j]的值获得由两种情况：
 *  （1）当S1[i]==S2[j]时，dp[i][j]=dp[i-1][j-1]+1;
 *   (2)当S1[i]！=S2[j]时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，
 *      取它们的最大者，即 dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。
 */
public class lengthOfLCSPUBLIC {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp=new int[m][n];
        //确定第一列的值
        for (int i = 0; i < m; i++) {
            if(nums1[i]==nums2[0])
            {
                for (int row = i; row < m; row++) {
                    dp[row][0]=1;
                }
                break;
            }
        }
        //确定第一行的值
        for (int j = 0; j <n ; j++) {
            if(nums2[j]==nums1[0])
            {
                for (int col = j; col <n ; col++) {
                    dp[0][col]=1;
                }
                break;
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n; j++) {
                if(nums1[i]==nums2[j])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,54,6,7};
        int[] nums2={1,2,8,10,54,6,7};
        int ans=new lengthOfLCSPUBLIC().lengthOfLCS(nums1,nums2);
        System.out.println(ans);
    }
}
