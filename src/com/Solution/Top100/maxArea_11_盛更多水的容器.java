package com.Solution.Top100;

public class maxArea_11_盛更多水的容器 {
    /**
     * 思路1： 暴力解法，时间复杂度O(n^2)
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2) return 0;
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = Math.min(height[j], height[i]) * (j - i);
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    /**
     * 思路2：双指针法，时间复杂度O(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = height.length;
        int max = 0;
        while (left < right) {
            int lh = height[left];
            int rh = height[right];
            int area = Math.min(lh, rh) * (right - left);
            max = Math.max(max, area);
            if (lh < rh)
                left++;
            else
                right--;
        }
        return max;
    }

}