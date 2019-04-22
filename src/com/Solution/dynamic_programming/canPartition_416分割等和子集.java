package com.Solution.dynamic_programming;

/**
 * 题目：给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:每个数组中的元素不会超过 100; 数组的大小不会超过 200
 *
 * 思路：动态规划
 * 当数组元素和为偶数时，首先求得w=sum/2;然后新建一个dp[w+1],令dp[0]=true, dp[i]表示有没有和为i的子数组
 * 状态转移方程dp[i]=dp[i]||dp[i-num]; 从后往前遍历（w->num）
 * 对方程的说明：当dp[i-num]为真时，dp[i]=dp[i-num+num]肯定也为真
 */
public class canPartition_416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum=getSum(nums);
        if(sum%2==1)
            return false;
        int w=sum/2;
        boolean dp[]=new boolean[w+1];
        dp[0]=true;
        for(int num:nums)
        {
            for (int i = w; i >=num ; i--) {
                dp[i]=dp[i]||dp[i-num];// 注意是从后往前！，先计算 dp[i] 再计算 dp[i-num]
            }
        }
        return dp[w];
    }

    private int getSum(int[] nums) {
        int sum=0;
        for(int i:nums)
            sum+=i;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        boolean ans=new canPartition_416分割等和子集().canPartition(nums);
        System.out.println(ans);
    }
}
