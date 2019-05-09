package com.Solution.Greedy;

/**
 * 题目：给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 思路：贪心算法，根据s中的每个字符，去寻找t中是否有满足条件的字符存在。
 */
public class isSubsequence_392_判断子序列 {
    //做法1
//    public boolean isSubsequence(String s, String t) {
//        if(s==null||s.length()==0)
//            return true;
//        if(t==null||t.length()==0)
//            return false;
//        int index=-1;
//        for (int i = 0; i < s.length(); i++) {//首先遍历s中的字符
//            int j=index+1;
//            for(;j<t.length();j++)//对每个s的字符，从t中寻找是否有满足条件的字符存在
//            {
//                if(t.charAt(j)==s.charAt(i))//找到字符，记录当前的下标位置
//                {
//                    index=j;
//                    break;
//                }
//                else if(j==t.length()-1)//没找到字符，则直接返回false
//                    return false;
//            }
//            if(j==t.length())//s中的字符还没有找完就已经遍历完t了
//                return false;
//        }
//        return true;
//    }


    //做法2：对方法1的优化,利用api方法indexOf定位元素
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index+1);
            if (index == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "aahbgdc";
        boolean ans = new isSubsequence_392_判断子序列().isSubsequence(s, t);
        System.out.println(ans);
    }
}
