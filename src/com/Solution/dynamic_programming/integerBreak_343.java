package com.Solution.dynamic_programming;

/**
 * 题目：给定一个正整数 n(>=2)，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 思路1：根据比较小的正整数，对其列举发现规律：当正整数大于4时，正整数应该尽量先拆分一个3出来， 如果剩余数字大于4，则进一步拆分3出来
 * 思路2：动态规划算法
 */
public class integerBreak_343 {
    //思路1
//    public int integerBreak(int n) {
//        if(n<=3)
//            return n-1;
//        if(n==4)
//            return n;
//        int sum=1;
//        while(n>4){
//            sum*=3;
//            n-=3;
//        }
//        sum*=n;
//        return sum;
//    }

    //思路2
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));//状态转移方程
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = new integerBreak_343().integerBreak(10);
        System.out.println(ans);
    }
}
