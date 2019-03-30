package com.Solution.Sort;

/**
 * 题目：荷兰国旗问题
 * 思路：三向切分快速排序，设置三个指针，lt,i,gt，i是工作指针，从头对数组进行遍历，lt用于记录存放0的下标，gt用于记录存放2的下标，
 * lt左边的区域和gt右边的区域是排好序的区域。i到gt之间的区域是待工作的区域。
 */
public class sortColors_75 {
    public void sortColors(int[] nums) {
        int lt=-1;
        int i=0;
        int gt=nums.length;
        while (i<gt)
        {
            if(nums[i]==1)
                i++;
            else if(nums[i]==0)
                swap(nums,++lt,i++);
            else
                swap(nums,i,--gt);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        int[] test={2,0,2,1,1,0};
        new sortColors_75().sortColors(test);
    }
}
