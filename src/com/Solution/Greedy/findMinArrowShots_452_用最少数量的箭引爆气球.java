package com.Solution.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * <p>
 * 思路：贪心算法
 * 思路1：自己想到的方法，先将区间依据区间中心点的大小进行从小到大排序，然后设置两个变量left和right记录区间的左右值
 * 当两个区间重叠时，left和right更新为重叠的子区间，在利用子区间去和下一个区间判断是否重叠，不重叠则将left和right更新为新的区间，同时计数器加1，以此循环。
 * <p>
 * <p>
 * 思路2：以区间的右边界值为依据进行从小到大排序，初始变量end为第一个区间的右边界值，从第二个区间开始往后遍历，判断当前区间的左边界是否小于等于前一个区间的右边界值
 * （i） 小于等于，则指针指向下一个边界，继续进行判断
 * （ii）大于，则计数器加一，同时更新end值为当前区间的右边界值
 */
public class findMinArrowShots_452_用最少数量的箭引爆气球 {
    //思路1
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        int cnt = 1;

        //区间依据区间中心点的大小进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        //首先初始化为第一个区间的左右边界值
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //与前一个重叠子区间进行比较，区间不重叠，则更新区间值为当前区间
            if (points[i][0] > right) {
                cnt++;
                left = points[i][0];
                right = points[i][1];
                continue;
            }
            //重叠，则继续更新为重叠子区间的左右边界值
            left = Math.max(left, points[i][0]);
            right = Math.min(right, points[i][1]);
        }
        return cnt;
    }


//    public int findMinArrowShots(int[][] points) {
//        if(points==null||points.length==0)
//            return 0;
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
//        int end=points[0][1];
//        int cnt=1;
//        for (int i = 1; i <points.length ; i++) {
//            if(points[i][0]<=end)
//                continue;
//            cnt++;
//            end=points[i][1];
//        }
//        return cnt;
//    }

    public static void main(String[] args) {
        int test[][] = {{7, 15}, {6, 14}, {8, 12}, {3, 4}, {4, 13}, {6, 14}, {9, 11}, {6, 12}, {4, 13}};
        int ans = new findMinArrowShots_452_用最少数量的箭引爆气球().findMinArrowShots(test);
        System.out.println(ans);
    }
}
