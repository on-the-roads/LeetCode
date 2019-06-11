package com.Solution.Math;

/**
 * 题目：给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 */
public class convertToTitle_168_Excel表列名称 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 0)
            return "";
        while (n != 0) {
            n--;//因为A-Z从1开始，所以每次做除法前先将n-1，这是这道题的难点，不容易想出来
            sb.append((char) ('A' + n % 26));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String ans = new convertToTitle_168_Excel表列名称().convertToTitle(701);
        System.out.println(ans);

    }
}
