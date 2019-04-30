package com.Solution.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 思路：贪心算法
 * 总体思想：找出不重合区间的个数，然后用区间总个数减去该值得到结果
 * 实现细节：以每个区间的右边界为依据进行排序，然后从区间集合从前往后遍历，后一个区间的左边界s与前一个满足条件的区间右边界e进行大小比较，
 * 如果s>=e,说明两个区间不重合，计数器加1，继续向后遍历。
 */
public class eraseOverlapIntervals_435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int  cnt=1;
        int end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<end)//不满足条件
                continue;
            //满足条件，cnt计数器++
            cnt++;
            end=intervals[i][1];
        }
        return intervals.length-cnt;
    }


    public static void main(String[] args) {
        int[][] test={{1,2}, {1,2}, {1,2}, {1,2}};
        int ans=new eraseOverlapIntervals_435_无重叠区间().eraseOverlapIntervals(test);
        System.out.println(ans);
    }
}
