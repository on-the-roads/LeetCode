package com.Solution.Math;

/**
 * 题目：给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class isPowerOfThree_326_3的幂 {
    public boolean isPowerOfThree(int n) {
        int yu = 0;
        while (n > 1) {
            yu = n % 3;
            if(yu!=0)
                return false;
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        boolean ans=new isPowerOfThree_326_3的幂().isPowerOfThree(9);
    }
}
