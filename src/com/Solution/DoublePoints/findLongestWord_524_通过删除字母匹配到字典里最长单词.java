package com.Solution.DoublePoints;

import java.util.*;

/**
 * 题目：给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 思路： 下面两种做法都是用双指针判断两个字符串是否匹配
 * 做法1：首先想到的思路，对字典里的每个字符串做判断是否能与给定字符串匹配，能的话将其加入到表中，并建立排序规则：首先根据字符串长度后根据字典顺序排序
 * 做法2：由于字符串默认是字典排序，所以不用自己建立规则，对做法1的运行时间进行了优化
 */
public class findLongestWord_524_通过删除字母匹配到字典里最长单词 {
    //做法1
    public String findLongestWord(String s, List<String> d) {
        List<String> matchList = new ArrayList<>();
        for (String str : d) {
            if (IsMatch(s, str))
                matchList.add(str);
        }
        Collections.sort(matchList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 != len2)
                    return o2.length() - o1.length();
                for (int i = 0; i < len1; i++) {
                    if (o1.charAt(i) != o2.charAt(i))
                        return o1.charAt(i) - o2.charAt(i);
                }
                return 0;
            }
        });
        return matchList.size() == 0 ? null : matchList.get(0);
    }

    public String findLongestWord_2(String s, List<String> d) {
        String ans="";
        for(String str:d)
        {
            int len1=ans.length();
            int len2=str.length();
            if(len1>len2||(len1==len2&&ans.compareTo(str)<0))
                continue;
            if(IsMatch(s,str))
                ans=str;
        }
        return ans;
    }

    private boolean IsMatch(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                p2++;
            }
            p1++;
        }
        if (p2 < s2.length())
            return false;
        return true;
    }


    public static void main(String[] args) {
        String s = "bab";
        String[] d = {"ba", "ab", "a", "b"};
        List<String> list = Arrays.asList(d);
        String ans = new findLongestWord_524_通过删除字母匹配到字典里最长单词().findLongestWord_2(s, list);
    }
}
