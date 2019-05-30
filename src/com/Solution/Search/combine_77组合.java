package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 思路：回溯
 */
public class combine_77组合 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n)
            return res;
        List<Integer> list = new ArrayList<>();
        dfs(n, 0, list, k);
        return res;
    }

    //自己首先想到的思路
//    private void dfs(int n, int i, List<Integer> list, int k) {
//        if (list.size() == k) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int j = i + 1; j <= n; j++) {
//            list.add(j);
//            dfs(n, j, list, k);
//            list.remove(list.size() - 1);
//        }
//
//    }

    //优化后的思路，进行剪枝
    private void dfs(int n, int i, List<Integer> list, int k) {
        if (k==0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= n-k+1; j++) {
            list.add(j);
            dfs(n, j, list, k-1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new combine_77组合().combine(4, 2);
    }
}
