package com.Solution.dynamic_programming;

/**
 * 题目：强盗在环形街区抢劫
 * 思路：将抢劫情况分为两种，1：抢劫第一家，那么最后被抢劫的住户只可能到倒数第二家。
 *                        2：抢劫第二家，那么最后被抢劫的住户可能到倒数第一家。
 */
public class rob_213 {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0||nums==null)
            return -1;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(robber(nums,0,len-2),robber(nums,1,len-1));
    }

    private int robber(int[] nums, int s, int e) {
        int pre2=0;
        int pre1=0;
        int ans=0;
        for (int i = s; i <=e ; i++) {
            ans=Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test={1,2,3,1};
        int ans=new rob_213().rob(test);
        System.out.println(ans);
    }
}
