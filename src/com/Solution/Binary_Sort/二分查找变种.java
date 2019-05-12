package com.Solution.Binary_Sort;
//在有重复元素的数组中找到target的最左位置下标
//注意！ 如果事先不清楚target是否在nums数组中，那么最后需要对返回结果位置的元素进行对比验证。
public class 二分查找变种 {
    public int sort(int[] nums,int target)
    {
        if(nums==null|nums.length==0)
            return -1;
        int l=0;
        int r=nums.length-1;
        while(l<r)//细节注意
        {
            int m=l+(r-l)/2;
            if(nums[m]>=target)
                r=m;//细节注意
            else
                l=m+1;//细节注意
        }
        return l;//细节注意
    }
}
