package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 思路：回溯
 */
public class combinationSum_39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, target, list, 0);
        return res;
    }

    //首先想到的思路
//    private void dfs(int[] candidates,int index, int target, List<Integer> list, int sum) {
//        if (sum == target) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        if (sum > target)
//            return;
//        for (int i = index; i < candidates.length; i++) {
//            list.add(candidates[i]);
//            dfs(candidates, i, target,list, sum + candidates[i]);
//            list.remove(list.size() - 1);
//        }
//    }

    //优化后
    private void dfs(int[] candidates, int index, int target, List<Integer> list, int sum) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(candidates, i, target-candidates[i], list, sum + candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new combinationSum_39_组合总和().combinationSum(new int[]{2, 3, 5}, 8);
    }
}
