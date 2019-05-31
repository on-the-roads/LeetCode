package com.Solution.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 思路：回溯，该题因为数组candidates有重复元素，为了防止最后的全排列有重复，要首先对candidates数组进行排序，然后满足j != 0 && candidates[j] == candidates[j - 1] && visited[j - 1] == false
 * 的元素不取。
 */
public class combinationSum2_40_组合总和II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        trace(candidates, target, -1, list, visited);
        return res;
    }

    private void trace(int[] candidates, int target, int i, List<Integer> list, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j < candidates.length; j++) {
            if (candidates[j] <= target) {
                if (j != 0 && candidates[j] == candidates[j - 1] && visited[j - 1] == false)
                    continue;
                list.add(candidates[j]);
                visited[j] = true;
                trace(candidates, target - candidates[j], j, list, visited);
                visited[j] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = new combinationSum2_40_组合总和II().combinationSum2(candidates, 8);
    }
}
