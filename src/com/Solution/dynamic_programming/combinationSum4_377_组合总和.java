package com.Solution.dynamic_programming;

/**
 * 题目：给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 思路：顺序完全背包问题
 */
public class combinationSum4_377_组合总和 {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        dp[0]=1;
        for (int i = 1; i <=target; i++) {
            for(int num:nums)
            {
                if(i>=num)
                    dp[i]+=dp[i-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={3,1,2};
        int target=4;
        int ans =new combinationSum4_377_组合总和().combinationSum4(nums,target);
        System.out.println(ans);
    }
}
