package com.Solution.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 题目：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 思路：
 * 相比题目46_全排列I，此题全排列出现重复的情况出现的原因是序列中包含重复数字。对重复数字，虽然采取不同的访问顺序，仍然可能出现全排列顺序相同。
 * 所以，此题首先要求对数组进行排序，将重复数组聚集在一起，然后当出现j != 0 && nums[j] == nums[j - 1] && !visited[j - 1]的情况时直接continue，这是
 * 最关键的一步，防止全排列有重复出现。
 */
public class permuteUnique_47_全排列II {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);//注意！！！！首先要排序！！！！！！！！！！
        dfs(nums, visited, list);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (j != 0 && nums[j] == nums[j - 1] && !visited[j - 1])
                continue;
            if (!visited[j]) {
                visited[j] = true;
                list.add(nums[j]);
                dfs(nums, visited, list);
                list.remove(list.size() - 1);
                visited[j] = false;
            }
        }
    }
}
