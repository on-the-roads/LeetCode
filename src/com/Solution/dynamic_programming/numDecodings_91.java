package com.Solution.dynamic_programming;

/**
 * 题目：一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 思路：动态规划思想，建立一个数组dp,dp[i]表示字符串从第0位到第i位的子串能够有多少种编码方法，通过判断新添加的字符是否为’0‘和前一个字符的关系来确定状态转移方程。
 */
public class numDecodings_91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        //将dp[0]和dp[1]先确定下来
        //若第一位为‘0’则解码无效
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        if(n<=1)
            return dp[0];
        int temp = Integer.valueOf(s.substring(0, 2));
        if (temp == 10 || temp == 20)
            dp[1] = 1;
        else if (temp <= 26)
            dp[1] = 2;
        else
            dp[1] = 1;

        for (int i = 2; i < n; i++) {
            //新添加的字符为0
            if (s.charAt(i) == '0') {
                //判断前一个字符是否为‘1’或者‘2’
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    dp[i] = dp[i - 2];
                else
                    return 0;//前一个字符不为‘1’或者‘2’，则字符编码无效
            } else//新添加的字符为‘1’到‘9’
            {
                //前一个字符为‘1’或者（前一个字符为‘2’同时新添加的字符为‘1’-‘6’）
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int ans = new numDecodings_91().numDecodings("226");
        System.out.println(ans);
    }
}
