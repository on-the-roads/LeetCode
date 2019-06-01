package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 思路：回溯
 */
public class subsets_78_子集 {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
            if(nums==null||nums.length==0)
                return res;
            int len=nums.length;
            List<Integer> list=new ArrayList<>();
        for (int size = 0; size <=len; size++) {
            trace(0,nums,size,list);
        }
        return res;
    }

    private void trace(int start,int[] nums, int k, List<Integer> list) {
        if(0==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <nums.length-k+1 ; i++) {
            list.add(nums[i]);
            trace(i+1,nums,k-1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] test={1,2,3};
        List<List<Integer>> nas=new subsets_78_子集().subsets(test);
    }
}
