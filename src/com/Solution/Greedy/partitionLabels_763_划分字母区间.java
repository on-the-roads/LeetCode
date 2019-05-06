package com.Solution.Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 思路：
 * 思路1：自己首先想到的思路，遍历字符串 找到和起点相同的最后一个字母 查看此区间里的字母最后的index是否超出区间 超出则更新区间 直至找到最大的index 则index - i + 1就是所求区间长度
 * 思路2：在思路1的基础上优化，利用长度为26的数组来存储每个字母最后出现的位置，降低了时间复杂度。
 */
public class partitionLabels_763_划分字母区间 {
//思路1：
//        public List<Integer> partitionLabels(String s) {
//            List<Integer> list = new ArrayList<>();
//            if (s == null || s.length() == 0)
//                return list;
//            int i = 0;
//            int index = 0;
//            int right=0;
//            while (i < s.length()) {
//                int start = s.charAt(i);
//                for (int j = s.length() - 1; j >= i + 1; j--) {//找到和起点相同的最后一个字母下标
//                    if (start == s.charAt(j)) {
//                        index = j;
//                        break;
//                    }
//                }
//                for (int j = i+1; j <index ; j++) {//查看此区间里的字母最后的index是否超出区间 超出则更新区间
//                    for (int k = s.length()-1; k >=i+1 ; k--) {
//                        if(s.charAt(k)==s.charAt(j))
//                        {
//                            right=Math.max(right,k);
//                            break;
//                        }
//                    }
//                }
//                list.add(right-i+1);
//                i=right+1;
//            }
//            return list;
//        }

    //思路2
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;
        int i = 0;
        int[] cache = new int[26];
        //存储每个字母最后出现的下标位置
        for (int j = 0; j < s.length(); j++) {
            cache[s.charAt(j) - 'a'] = j;
        }
        //找到和起点相同的最后一个字母 查看此区间里的字母最后的index是否超出区间 超出则更新区间
        while (i < s.length()) {
            int index = cache[s.charAt(i) - 'a'];//和起点相同的最后一个字母
            int right=index;
            for (int j = i + 1; j < index; j++) {
                right = Math.max(right, cache[s.charAt(j) - 'a']);
            }
        list.add(right - i + 1);
        i = right + 1;
    }
        return list;
}

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List ans = new partitionLabels_763_划分字母区间().partitionLabels(s);

    }
}
