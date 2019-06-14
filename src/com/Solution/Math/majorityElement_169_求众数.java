package com.Solution.Math;

import java.util.Arrays;

/**
 * 题目：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 思路1:对数组进行排序，数组中间的数就是答案，时间复杂度O(nlogn)
 * 思路2：摩尔投票法 Moore Voting，需要 O(n) 的时间和 O(1) 的空间
 */
public class majorityElement_169_求众数 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement_2(int[] nums) {
        int ans=0;//候选数
        int cnt=0;//次数
        for(int num:nums)
        {
            if(cnt==0)//cnt==0时，将当前数作为候选数
            {
                ans=num;
                cnt++;
            }
            else if(ans==num)//当前数等于候选数，则次数继续加1
                cnt++;
            else
                cnt--;//cnt!=0 同时当前数不等于候选数，则次数减1
        }
        return ans;
    }

        public static void main(String[] args) {
        int ans=new majorityElement_169_求众数().majorityElement_2(new int[]{2,2,1,1,1,2,2});
        System.out.println(ans);
    }
}
