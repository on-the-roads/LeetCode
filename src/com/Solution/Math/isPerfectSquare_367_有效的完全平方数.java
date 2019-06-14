package com.Solution.Math;

/**
 * 题目：给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 思路：由于完全平方数是由从1开始，公差为2的递增等差数列的和Sn构成，因此可将num从1开始减下去，最后判断是否为0
 */
public class isPerfectSquare_367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int cnt=0;
        while(num>0)
        {
            int gap=2*cnt+1;
            num-=gap;
            cnt++;
        }
        return 0==num;
    }

    public static void main(String[] args) {
        boolean ans=new isPerfectSquare_367_有效的完全平方数().isPerfectSquare(2147483647);
        System.out.println(ans);
    }
}
