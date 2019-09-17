package com.Solution.Top100;

public class searchRange_34_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 主要是熟练运用查找最左元素下标的二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = sortLeft(nums, target);
        if (left < 0) return new int[]{-1, -1};
        int right = sortLeft(nums, target + 1);
        right = right < 0 ? -(right + 1) : right;
        if (nums[right] != target)
            right--;
        return new int[]{left, right};
    }


    private int sortLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cur = nums[mid];
            if (cur >= target)
                r = mid;
            else l = mid + 1;
        }
        if (nums[l] == target) return l;
        return -(l + 1);
    }
}
