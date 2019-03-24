package com.Solution.String;


/**
 *题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 思路：
 *      1.可以使用hashmap
 *      2.由于题目要求字符串中都是小写字母，所以可以用长度为26的数组来存放每个字符出现的次数。这里可以不用针对两个字符串设置两个数组，在同一个
 *      数组中先对元素进行自增，再对元素进行递减，最终判断是否数组所有的元素均为0.
 */
public class isAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        int[] arr = new int[26];
        for (char c_s : s.toCharArray())
            arr[c_s - 'a']++;
        for (char c_t : t.toCharArray())
            arr[c_t - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        boolean ans=new isAnagram_242().isAnagram(s,t);
    }
}
