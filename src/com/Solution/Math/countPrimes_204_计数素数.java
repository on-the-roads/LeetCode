package com.Solution.Math;

import java.util.Arrays;

/**
 * 题目：统计所有小于非负整数 n 的质数的数量。
 * 思路：埃拉托斯特尼筛法
 */
public class countPrimes_204_计数素数 {
    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        int count = 0;
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime,true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (long j = (long)(i)*i ; j<n; j+=i) {
                    isPrime[(int)j] = false;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int ans=new countPrimes_204_计数素数().countPrimes(499979);
        System.out.println(ans);
    }
}
