package com.Solution.Binary_Sort;

//二分查找法模板
public class BinarySort_Template {
    public int sort(int[] nums,int target)
    {
        if(nums==null||nums.length==0)
            return -1;
        int l=0;
        int r=nums.length-1;
        while(l<=r)   //细节注意
        {
            int m=l+(r-l)/2;//细节注意
            if(nums[m]==target)
                return m;
            if(nums[m]>target)
                r=m-1;//细节注意
            else
                l=m+1;//细节注意
        }
        return -1;
    }

}
