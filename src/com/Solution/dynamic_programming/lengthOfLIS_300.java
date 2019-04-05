package com.Solution.dynamic_programming;

/**
 * 题目：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class lengthOfLIS_300 {
    //思路1:时间复杂度为O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        int max = 1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int count = 1;
//            int temp=nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[j]>temp) {
//                    count++;
//                    temp=nums[j];
//                }
//            }
//            max=Math.max(max,count);
//        }
//        return max;
//    }


    /*
      思路2：时间复杂度为O(nlogn),定义一个tails数组，其中tails[i]存放长度为i+1的数组的最长递增子序列的最后一个元素。对于一个新的元素x:
            1.x大于tails数组的所有值，则将x添加到tails数组的末尾，长度+1
            2.   tail[i-1]<x<tail[i]，则将tail[i]替换为x

            二分查找时间复杂度为O(logn)，遍历元素复杂度为O(n)
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len,num );
            tails[index]=num;
            if(index==len)
                len++;
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int num) {
        int l=0;
        int r=len-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int temp=tails[mid];
            if(temp>num)
                r=mid-1;
            else if(temp<num)
                l=mid+1;
            else
                return mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = new lengthOfLIS_300().lengthOfLIS(test);
        System.out.println(ans);
    }
}
