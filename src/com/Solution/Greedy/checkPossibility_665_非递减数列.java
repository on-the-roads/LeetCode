package com.Solution.Greedy;

/**
 * 题目：给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 思路1：
 * 当出现nums[i-1]>nums[i]时,首先考虑nums[i-1]=nums[i],这样对下标i以后的数组的影响较小；但是有可能nums[i-2]>nums[i],这时候nums[i-1]=nums[i]不能满足条件
 * 需要nums[i]=nums[i-1].
 */
public class checkPossibility_665_非递减数列 {
    //思路1
    public boolean checkPossibility1(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i])
                continue;
            cnt++;//出现逆序的情况，计数器加1
            if (i - 2 >= 0 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1];
            else nums[i - 1] = nums[i];
        }
        return cnt <= 1;
    }


    //思路2
    public boolean checkPossibility2(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int cnt = 0;
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i - 1;
                if (index - 1 >= 0 && index + 2 < nums.length) {
                    if (nums[index - 1] > nums[index + 1] && nums[index] > nums[index + 2])
                        return false;
                }
                cnt++;
            }
            if (cnt > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = {4, 2, 1};
        boolean ans = new checkPossibility_665_非递减数列().checkPossibility1(test);
        System.out.println(ans);
    }
}
