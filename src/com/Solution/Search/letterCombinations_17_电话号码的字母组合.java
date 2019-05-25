package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 思路：回溯
 */
public class letterCombinations_17_电话号码的字母组合 {
    private String[] strings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return list;
        trace(new StringBuilder(), 0, digits);
        return list;
    }

    //回溯法
    private void trace(StringBuilder sb, int index, String digits) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = strings[digits.charAt(index) - '2'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            trace(sb, index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> list = new letterCombinations_17_电话号码的字母组合().letterCombinations("23");
    }
}
