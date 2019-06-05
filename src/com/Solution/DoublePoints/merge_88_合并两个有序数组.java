package com.Solution.DoublePoints;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 思路：双指针
 */
public class merge_88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)
            return;
        int p1=m-1;
        int p2=n-1;
        int des=m+n-1;
        while (des>=0)
        {
            while (p1>=0&&p2>=0)
            {
                if(nums1[p1]>=nums2[p2])
                    nums1[des--] = nums1[p1--];
                else
                    nums1[des--]=nums2[p2--];
            }
            if(p1>=0)
                return;
            if(p2>=0)
                nums1[des--]=nums2[p2--];
        }
        return;
    }
}
