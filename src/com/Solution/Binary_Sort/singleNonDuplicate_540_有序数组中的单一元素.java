package com.Solution.Binary_Sort;

/**
 * 题目：给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 思路：
 *      思路1:首先想到的思路，对数组元素以0 2 4 6.. 2n的顺序进行遍历，找到第一个nums[i]!=nums[i+1]的元素，即为所求。缺点是时间复杂度为O(n)
 *      思路2：能够比O(n)更好的时间复杂度首先考虑O(logn)，也就是用二分法查找
 *              设m为偶数，如果nums[m]=nums[m+1],则说明单元素下标>=m+2;否则单元素下标<=m。这样就缩小了查找区间，进一步的进行查找。
 **/
public class singleNonDuplicate_540_有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r)
        {
            int m=l+(r-l)/2;
            if(m%2==1)//确保m下标为偶数
                m--;
            if(nums[m]==nums[m+1])
                l=m+2;
            else
                r=m;
        }
        return nums[l];
    }
}
