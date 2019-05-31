package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * 思路：回溯
 */
public class combinationSum3_216_组合总和III {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n || (k == n && n != 1)||n>45)
            return res;
        List<Integer> list = new ArrayList<>();
        trace(n, k,1, list);
        return res;
    }

    private void trace(int target, int k, int start, List<Integer> list) {
        if (list.size() == k && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() == k || target == 0)
            return;
        for (int i = start; i <=9 ; i++) {
            if(i<=target)
            {
                list.add(i);
                trace(target-i,k,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans=new combinationSum3_216_组合总和III().combinationSum3(2,2);
    }
}
