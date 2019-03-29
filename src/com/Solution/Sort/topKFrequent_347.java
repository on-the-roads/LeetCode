package com.Solution.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 题目：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 思路:利用桶结构，bucket中存放元素出现的频率，bucket[i]中存放出现该频率的元素。
 */
public class topKFrequent_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) == null)
                map.put(i, 1);
            else {
                int value = map.get(i);
                map.put(i, value + 1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null)
                bucket[map.get(key)] = new ArrayList<>();
            bucket[map.get(key)].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && k - ans.size() > 0; i--) {
            if (bucket[i] != null) {
                if (bucket[i].size() <= k - ans.size())
                    ans.addAll(bucket[i]);
                else
                    ans.addAll(bucket[i].subList(0,k-ans.size()));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        List ans = new topKFrequent_347().topKFrequent(nums, 1);
    }
}
