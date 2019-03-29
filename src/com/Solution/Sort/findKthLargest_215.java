package com.Solution.Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：TopK问题
 * 思路：快速排序，堆排序
 */
public class findKthLargest_215 {

    public int findKthLargest(int[] nums, int k) {
        /**
         * 使用最大堆
         */
//        PriorityQueue<Integer> heap=new PriorityQueue<>(nums.length, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for(int i:nums)
//        {
//            heap.offer(i);
//        }
//        for (int i = 0; i < k-1; i++) {
//            heap.poll();
//        }
//        return heap.peek();

        /**
         *  使用最小堆
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] temp = {1, 2, 5, 3, 6, 4};
        int ans = new findKthLargest_215().findKthLargest(temp, 2);
        System.out.println(ans);
    }
}
