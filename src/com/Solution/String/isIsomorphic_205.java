package com.Solution.String;

/**
 * 题目：给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 你可以假设 s 和 t 具有相同的长度。
 * 思路：建立两个数组用来保存字符上一次出现的位置，初始时默认值为0，两个字符串同时向后遍历，当遇到上一个字符出现的位置不相同时说明不是同构字符串。
 */
public class isIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
            int[] preindexnum_s=new int[256];
            int[] preindexnum_t=new int[256];
        for (int i = 0; i < s.length(); i++) {
            if(preindexnum_s[s.charAt(i)]!=preindexnum_t[t.charAt(i)])
                return false;
            preindexnum_s[s.charAt(i)]=i+1;//保存字符出现的位置
            preindexnum_t[t.charAt(i)]=i+1;//保存字符出现的位置
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans=new isIsomorphic_205().isIsomorphic("egg","loo");
    }
}
