package com.Solution.dynamic_programming;

/**
 * 题目：给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 思路：
 */
public class findTargetSumWays_494目标和 {
    private int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        find(nums,S,0,0);
        return count;
    }

    private void find(int[] nums, int target, int index, int sum) {
        if(sum==target&&index==nums.length)
            count++;
        if(index>=nums.length)
            return;
        find(nums,target,index+1,sum-nums[index]);
        find(nums,target,index+1,sum+nums[index]);
    }

    public static void main(String[] args) {
     int[] nums={1, 1, 1, 1, 1};
     int S=3;
     int ans=new findTargetSumWays_494目标和().findTargetSumWays(nums,S);
        System.out.println(ans);
    }
}
