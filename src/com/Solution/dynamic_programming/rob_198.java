package com.Solution.dynamic_programming;

/**
 * 题目：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class rob_198 {
    //思路1
//    public int rob(int[] nums) {
//        int q=0;
//        for (int i = 0; i < nums.length; i++) {
//            q=Math.max(q,robber(nums,i));
//        }
//        return  q;
//    }
//
//    private int robber(int[] nums, int s) {
//        if(s>=nums.length)
//            return  0;
//        else if(s>=nums.length-2)
//            return nums[s];
//
//        return Math.max(nums[s]+robber(nums,s+2),(nums[s+1]+robber(nums,s+3)));
//    }

    //思路2：定义dp数组来存储最大的抢劫量，其中dp[i]指的是抢劫到第i家时的最大抢劫量。
    public int rob(int[] nums) {
        int pre1=0;
        int pre2=0;
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            ans=Math.max(pre1,pre2+nums[i]);//状态转移方程
            pre2=pre1;
            pre1=ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {9, 1, 1, 9, 1, 9};
        int ans = new rob_198().rob(test);
        System.out.println(ans);
    }
}
