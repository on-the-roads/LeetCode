package com.Solution.Math;

import java.util.Arrays;

/**
 * 题目：给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 思路：最大乘积有两种情况，1：两个负数*一个正数   2：三个正数相乘
 */
public class maximumProduct_628_三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return Math.max(nums[0]*nums[1],nums[n-2]*nums[n-3])*nums[n-1];
    }
}
