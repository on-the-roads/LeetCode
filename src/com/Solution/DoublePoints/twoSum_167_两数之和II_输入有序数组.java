package com.Solution.DoublePoints;

/**
 * 题目：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 思路：双指针，思路1较容易想到，设置一前一后指针，但是时间复杂度较高，O(n^2)；
 *             思路2设置首尾指针，向中间遍历，时间复杂度O(n)
 */
public class twoSum_167_两数之和II_输入有序数组 {
    //思路1
    public int[] twoSum(int[] numbers, int target) {
        int[] ans=new int[2];
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i]+numbers[j]==target)
                {
                    ans[0]=i+1;
                    ans[1]=j+1;
                    break;
                }
            }
        }
        return ans;
    }

    //思路2：比思路1时间复杂度更优
    public int[] twoSum2(int[] numbers, int target) {
        int right=numbers.length-1;
        int left=0;
        int sum=0;
        while(left<right)
        {
             sum=numbers[left]+numbers[right];
             if(sum==target)
             {
                 return  new int[]{left+1,right+1};
             }
            if(sum<target)
            {
                left++;
            }
            else
                right--;
        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr={2, 7, 11, 15};
        int[] ans=new twoSum_167_两数之和II_输入有序数组().twoSum2(arr,9);
    }
    }
