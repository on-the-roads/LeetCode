package com.Solution.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 题目：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 思路：回溯法
 */
public class subsetsWithDup_90_子集II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, visited, list, 0);
        }
        return res;
    }

    private void dfs(int[] nums, int k, boolean[] visited, List<Integer> list, int start) {
        if (0 == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length - k + 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, k - 1, visited, list, i + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
