package com.Solution.String;

/**
 * 题目：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 思路：利用数组统计每个字符出现的次数，次数大于1就能够构成回文，最后再判断字符串中有没有出现一次的字符串，有就再将结果+1作为回文串的中间字符。
 */
public class longestPalindrome_409 {
    public int longestPalindrome(String s) {
        int[] arr=new int[58];//97(a)+25-65(A)+1=58;
        for(char c:s.toCharArray())
            arr[c-'A']++;
        int sum=0;
        boolean HasOnlyOne=false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1)
                HasOnlyOne=true;
            sum+=arr[i]/2*2;
        }
        if(HasOnlyOne)
            sum+=1;
        return sum;
    }

    public static void main(String[] args) {
        int ans=new longestPalindrome_409().longestPalindrome("abccccdd");
    }
}
