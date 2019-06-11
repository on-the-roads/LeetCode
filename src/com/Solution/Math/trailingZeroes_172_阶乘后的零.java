package com.Solution.Math;

/**
 * 题目：给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 思路：n!中的0是由2和5相乘产生的，而在阶乘中5的个数比2少，所以只用统计5的个数就可以了，即 ans=N/5+N/(5^2)+N/(5^3)+....
 *
 * 类似的题还有判断N! 的二进制表示中最低位 1 的位置
 */
public class trailingZeroes_172_阶乘后的零 {
    public int trailingZeroes(int n) {
        if(n<5)
            return 0;
        return n/5+trailingZeroes(n/5);
    }

    public static void main(String[] args) {
        int ans=new trailingZeroes_172_阶乘后的零().trailingZeroes(125);
        System.out.println(ans);
    }
}
