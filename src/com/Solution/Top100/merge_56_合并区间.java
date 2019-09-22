package com.Solution.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int pre = intervals[0][0];
        int after = intervals[0][1];
        int index = 0;
        ArrayList<int[]> list = new ArrayList();
        while (index < intervals.length - 1) {
            if (after >= intervals[index + 1][0]) {
                if (after < intervals[index + 1][1])
                    after = intervals[index + 1][1];
            } else {
                list.add(new int[]{pre, after});
                pre = intervals[index + 1][0];
                after = intervals[index + 1][1];
            }
            index++;
        }
        list.add(new int[]{pre, after});
        return list.toArray(new int[list.size()][2]);
    }
}
