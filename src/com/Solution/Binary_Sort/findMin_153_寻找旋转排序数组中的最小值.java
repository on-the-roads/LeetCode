package com.Solution.Binary_Sort;

/**
 * 题目:假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * 思路：此题为二分查找的变种。将得到的中间元素nums[m]与数组最后一个元素nums[len-1]做对比，
 *      nums[m]<nums[len-1]，则说明target的下标<=m;
 *       nums[m]>nums[len-1],则说明target的下标>m;
 */
public class findMin_153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(nums[m]<nums[nums.length-1])
                r=m;
            else
                l=m+1;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int nums[]={3,4,5,1,2};
        int ans=new findMin_153_寻找旋转排序数组中的最小值().findMin(nums);
        System.out.println(ans);
    }
}
