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
        public List<Integer> partitionLabels(String s) {
            List<Integer> list = new ArrayList<>();
            if (s == null || s.length() == 0)
                return list;
            int left = 0;
            while (left < s.length()) {
                int right=left;
                for (int j = left; j <=right ; j++) {//查看此区间里的字母最后的index是否超出区间 超出则更新区间
                    for (int k = s.length()-1; k >=left+1 ; k--) {
                        if(s.charAt(k)==s.charAt(j))
                        {
                            right=Math.max(right,k);
                            break;
                        }
                    }
                }
                list.add(right-left+1);
                left=right+1;
            }
            return list;
        }

   // 思路2
//    public List<Integer> partitionLabels(String s) {
//        List<Integer> list = new ArrayList<>();
//        if (s == null || s.length() == 0)
//            return list;
//        int[] cache = new int[26];
//        //存储每个字母最后出现的下标位置
//        for (int j = 0; j < s.length(); j++) {
//            cache[s.charAt(j) - 'a'] = j;
//        }
//        int left = 0;
//        while (left < s.length()) {
//            int right=left;
//            for (int j = left ; j <=right; j++) {
//                right = Math.max(right, cache[s.charAt(j) - 'a']);
//            }
//        list.add(right - left + 1);
//        left = right + 1;
//    }
//        return list;
//}

    public static void main(String[] args) {
        String s ="qiejxqfnqceocmy";
        List ans = new partitionLabels_763_划分字母区间().partitionLabels(s);

    }
}
