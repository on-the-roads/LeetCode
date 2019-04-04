package com.Solution.dynamic_programming;

/**
 * 题目：给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
public class NumArray {
   private int[] sum=new int[100];

    public NumArray(int[] nums) {
        for (int i = 1; i <=nums.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */