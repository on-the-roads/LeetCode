package com.Solution.dynamic_programming;

import java.util.ArrayList;

/**
 * 题目：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 思路：动态规划思想，状态转移方程为dp[n]=Math.min(dp[n],dp[n-square]+1); 其中square为小于等于n的平方数
 */
public class numSquares_279按平方数来分割整数 {
    public int numSquares(int n) {
        ArrayList<Integer> squareList = getSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i)
                    break;
                min=Math.min(min,dp[i-square]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }

    private ArrayList<Integer> getSquareList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }


    public static void main(String[] args) {
        int ans=new numSquares_279按平方数来分割整数().numSquares(13);
        System.out.println(ans);
    }
}
