package com.Solution.dynamic_programming;

/**
 * 题目：最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 * 思路：动态规划，尝试写出几个数字用不完全归纳法就可以找到规律，对于质数，结果只能是质数；对于非质数，判断是否有因子2和3.
 */
public class minSteps_650_只有两个键的键盘 {
    public int minSteps(int n) {
        int[] dp=new int[n+1];
        for (int i = 2; i <=n ; i++) {
            if(i%2==0)
                dp[i]=dp[i/2]+2;
            else if(i%3==0)
                dp[i]=dp[i/3]+3;
            else//质数
                dp[i]=i;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans=new minSteps_650_只有两个键的键盘().minSteps(16);
        System.out.println(ans);
    }
}
