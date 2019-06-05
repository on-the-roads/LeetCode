package com.Solution.DoublePoints;

/**
 * 题目：给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 思路：双指针
 */
public class validPalindrome_680_验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return isHuiwen(s, left + 1, right) || isHuiwen(s, left, right - 1);
            left++;
            right--;
        }
        return true;
    }

    private boolean isHuiwen(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new validPalindrome_680_验证回文字符串Ⅱ().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
    }
}
