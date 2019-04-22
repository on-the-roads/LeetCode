package com.Solution.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 思路：由于字典中的单词没有使用次数的限制，所以是背包问题；又由于该问题涉及到字典中单词的使用顺序，所以可看做是涉及顺序的完全背包问题。
 */
public class wordBreak_139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        for (int i = 1; i <=n ; i++) {
            for(String word:wordDict)//注意：对字典的遍历要放在里面一层
            {
                int len=word.length();
                if(i>=len&&word.equals(s.substring(i-len,i)))
                    dp[i]=dp[i]||dp[i-len];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        List<String> liststring=new ArrayList<>();
        for (String ss:wordDict)
            liststring.add(ss);
        boolean ans=new wordBreak_139_单词拆分().wordBreak(s,liststring);
        System.out.println(ans);
    }
}
