package com.Solution.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 思路：由于字典中的单词没有使用次数的限制，所以是背包问题；又由于该问题涉及到字典中单词的使用顺序，所以可看做是涉及顺序的完全背包问题。
 */
public class wordBreak_139_单词拆分 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict)//注意：对字典的遍历要放在里面一层
            {
                int len = word.length();
                if (i >= len && word.equals(s.substring(i - len, i)))
                    dp[i] = dp[i] || dp[i - len];
            }
        }
        return dp[n];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (i >= str.length() && s.substring(i - str.length(), i).equals(str))
                    dp[i] = dp[i] || dp[i - str.length()];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        String[] wordDict = {"apple", "pen"};
        List<String> liststring = new ArrayList<>();
        for (String ss : wordDict)
            liststring.add(ss);
        boolean ans = new wordBreak_139_单词拆分().wordBreak2(s, liststring);
        System.out.println(ans);
    }
}
