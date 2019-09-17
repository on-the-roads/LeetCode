package com.Solution.Top100;

public class search_33_搜索旋转排序数组 {
    /**
     * 思路：  先利用二分查找旋转点（最小元素的下标）
     * 再根据旋转点将数组分割为左右两部分有序数组，分别用二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = findstart(nums);
        if (start != 0 && nums[0] <= target)
            return binarySort(nums, 0, start - 1, target);
        return binarySort(nums, start, nums.length - 1, target);
    }


    private int binarySort(int[] nums, int l, int r, int target) {
        int left = l;
        int right = r;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = nums[mid];
            if (temp == target) return mid;
            else if (temp > target) right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    /**
     * 查找旋转点
     * @param nums
     * @return
     */
    private int findstart(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int lnum = nums[left];
            int rnum = nums[right];
            if (lnum < rnum) return left;
            int mid = left + (right - left) / 2;
            int temp = nums[mid];
            if (temp > rnum)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
