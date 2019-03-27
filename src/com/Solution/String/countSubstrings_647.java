package com.Solution.String;

/**
 * 题目：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 思路：回文字符串根据字符个数分为两种，奇数个如“aba"和偶数个”aa"。利用递归思路从某一个字符（奇数的情况）或者两个字符（偶数的个数）出发向两边扩展进行判断。
 */
public class countSubstrings_647 {
    public int countSubstrings(String s) {
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            ans+=isHuiWen(s,i,i,0);//判断字符长度为奇数的回文串个数
            ans+=isHuiWen(s,i,i+1,0);//判断字符长度为偶数的回文串个数
        }
        return ans;
    }

    private int isHuiWen(String s, int l,int r, int gap) {
        if(l-gap<0||r+gap>s.length()-1)
            return 0;
        if(s.charAt(l-gap)!=s.charAt(r+gap))
            return 0;
        return 1+isHuiWen(s, l,r, gap + 1);
    }

    public static void main(String[] args) {
        int ans=new countSubstrings_647().countSubstrings("abc");
    }
}
