package com.Solution.Greedy;

/**
 * 题目：假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 思路：贪心思想
 */
public class canPlaceFlowers_605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      int len=flowerbed.length;
      int cnt=0;
        for (int i = 0; i < len; i++) {
            if(flowerbed[i]==1)
                continue;
            int pre=i==0?0:flowerbed[i-1];
            int next=i==len-1?0:flowerbed[i+1];
            if(pre+next==0) {
                flowerbed[i]=1;
                cnt++;
            }
        }
        return cnt>=n;
    }


}
