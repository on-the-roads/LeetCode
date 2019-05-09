package com.Solution.Greedy;

/**
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 思路：贪心算法
 */
public class maxSubArray_53_最大子序和 {
    //做法1
//    public int maxSubArray(int[] nums) {
//        if(nums==null||nums.length==0)
//            return 0;
//        int max=Integer.MIN_VALUE;
//        int sum=0;
//        for (int i = 0; i < nums.length; i++) {
//            sum+=nums[i];
//            max=Math.max(max,sum);//记录最大的子序和
//            sum=Math.max(0,sum);//当sum<0时，sum=0
//        }
//        return max;
//    }


    //做法2
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int presum = nums[0];
        int max = presum;
        for (int i = 1; i < nums.length; i++) {
            presum = presum > 0 ? presum + nums[i] : nums[i];//遍历到第i个元素时，当sum[0~i-1]大于0时就继续加当前元素，否则从当前元素重新加起
            max = Math.max(max, presum);//记录最大的子序和
        }
        return max;
    }

    public static void main(String[] args) {
        int test[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = new maxSubArray_53_最大子序和().maxSubArray(test);
        System.out.println(ans);
    }
}
