package com.Solution.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：使用双指针思路
 * 首先将元素排序，对于第一个元素到倒数第三个元素nums[i]，都设置双指针，l指针首先为nums[i+1],r指针为nums[nums.length-1]
 * 然后根据三数之和移动双指针，在这个过程中要记得去重。
 */
public class threeSum_15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList();
        if (nums == null || nums.length == 0)
            return ansList;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int left = nums[i];
            if (left > 0)
                break;
            while (l < r) {
                int mid = nums[l];
                int right = nums[r];
                int sum = left + mid + right;
                if (sum > 0)
                    r--;
                else if (sum < 0)
                    l++;
                else {
                    ansList.add(Arrays.asList(left, mid, right));
                    //去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }

            }
        }
        return ansList;
    }
}
