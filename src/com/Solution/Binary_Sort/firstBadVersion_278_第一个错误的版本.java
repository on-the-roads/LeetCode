package com.Solution.Binary_Sort;

/**
 * 题目：你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 思路：此题为二分查找的变种，查找错误版本中的最低版本，相当于在有重复元素的数组中查找下标最小的重复元素。
 */
public class firstBadVersion_278_第一个错误的版本 {
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        while(l<r)
        {
            int m=l+(r-l)/2;
            if(!isBadVersion(m))
                l=m+1;
            else
                r=m;
        }
        return l;
    }


    boolean isBadVersion(int version){
        return version>=2;
    }
}
