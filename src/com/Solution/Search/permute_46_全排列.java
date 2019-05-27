package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目： 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 思路：回溯，由于该题中序列为无重复数字，所以我通过list.contain（）方法判断数字是否已被添加，更一般的，用一个boolean数组来存放访问标志
 */
public class permute_46_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new permute_46_全排列().permute(nums);
    }
}
