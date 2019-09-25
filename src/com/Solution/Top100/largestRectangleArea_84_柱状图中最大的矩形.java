package com.Solution.Top100;

public class largestRectangleArea_84_柱状图中最大的矩形 {
    /**
     * 思路1：按列计算，计算每个列作为矩形的高时矩阵的面积，找到其中的最大矩形
     * 时间：O(n^2)
     * 空间：O(1)
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        int max=0;
        for(int i=0;i<heights.length;i++){
            int h=heights[i];
            int l=i;
            int r=i;
            while(--l>=0)
                if(heights[l]<h)break;
            while(++r<heights.length)
                if(heights[r]<h) break;
            int area=(r-l-1)*h;
            max=Math.max(max,area);
        }
        return max;
    }

    /**
     * 思路2：分治思想，
     * 最大面积矩形存在于以下几种情况：
     * 确定了最矮柱子以后，矩形的宽尽可能往两边延伸。
     * 在最矮柱子左边的最大面积矩形（子问题）。
     * 在最矮柱子右边的最大面积矩形（子问题）。
     *
     * 时间：O(nlogn),最坏O(n^2)
     * 空间：最坏O(n)，递归深度
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return process(heights, 0, heights.length - 1);
    }



    private int process(int[] arr, int l, int r) {
        if (l > r) return 0;
        int minIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[minIndex])
                minIndex = i;
        }
        return Math.max(arr[minIndex] * (r - l + 1), Math.max(process(arr, l, minIndex - 1), process(arr, minIndex + 1, r)));
    }
}
