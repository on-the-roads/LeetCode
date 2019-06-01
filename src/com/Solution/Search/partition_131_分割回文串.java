package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * <p>
 * 思路：回溯，要熟练运用String类的subString方法
 */
public class partition_131_分割回文串 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return res;
        List<String> list = new ArrayList<>();
        trace(s, list);
        return res;
    }

    private void trace(String s, List<String> list) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isHuiwen(s, 0, i)) {
                list.add(s.substring(0, i + 1));
                trace(s.substring(i + 1), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isHuiwen(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = new partition_131_分割回文串().partition(s);
    }
}
