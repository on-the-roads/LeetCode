package com.Solution.DoublePoints;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 思路：双指针
 */
public class reverseVowels_345_反转字符串中的元音字母 {
    private HashSet<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (left < right && !set.contains(s.charAt(left))) {
                left++;
            }
            while (left < right && !set.contains(s.charAt(right))) {
                right--;
            }
            swap(sb, left, right);
            left++;
            right--;
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb, int left, int right) {
        char temp = sb.charAt(right);
        sb.setCharAt(right, sb.charAt(left));
        sb.setCharAt(left, temp);
    }


    public static void main(String[] args) {
        String ans = new reverseVowels_345_反转字符串中的元音字母().reverseVowels("ai");
        System.out.println(ans);
    }

}
