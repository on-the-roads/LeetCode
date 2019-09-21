package com.Solution.Top100;

public class trap_42_接雨水 {
    /**
     * 按列求解，从第二列墙遍历到倒数第二列墙，对每一列墙，找出其左右两边最高的墙的较矮的那一个，判断其和当前墙高度大小关系
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        int maxLeft = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            if (height[i] < Math.min(maxLeft, maxRight[i]))
                sum += Math.min(maxLeft, maxRight[i]) - height[i];
        }
        return sum;
    }
}
