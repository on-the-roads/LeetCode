package com.Solution.Math;

import java.util.Arrays;

/**
 * 题目：给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 要求:时间复杂度为O(n)，空间复杂度为O(1)
 *
 * 思路：对每一个数，先从nums[1]开始向右遍历得到其左边数乘积和，再从nums[len-1]开始向左遍历得到其右边数乘积和，这样将乘积和分为左右两部分分别获取就满足了时间复杂度
 */
public class productExceptSelf_238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,1);//优化：仅设置res[0]=1即可
        int left=1;
        for (int i = 1; i <n ; i++) {
            left=left*nums[i-1];
            res[i]=left;
        }
        int right=1;
        for (int i = n-2; i >=0 ; i--) {
            right=right*nums[i+1];
            res[i]=res[i]*right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ans=new productExceptSelf_238_除自身以外数组的乘积().productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");

        }
    }
}
