package com.Solution.Math;

import java.util.Arrays;

/**
 * 题目：给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * 思路：将数组排序后，找到中位数，将所有数都变为中位数能够得到最少的操作步骤.
 *
 *
 */
public class minMoves2_462_最少移动次数使数组元素相等II {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int midnum=nums[nums.length/2];
        int r=nums.length-1;
        int l=0;
        int sum=0;
        while(l<=r)
        {
            sum+=nums[r--]-nums[l++];//（右边-中位数）+（中位数-左边）=右边-左边
        }
        return sum;
    }

    public static void main(String[] args) {
        int ans=new minMoves2_462_最少移动次数使数组元素相等II().minMoves2(new int[]{1,1,4});
        System.out.println(ans);
    }
}
