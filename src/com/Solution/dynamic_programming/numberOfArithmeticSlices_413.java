package com.Solution.dynamic_programming;

/**
 * 题目：等差数列划分
 * 思路：设A[i]表示A[0-i]的数组的子等差数组个数，那么A[i]=A[i-1]+i-1;  初始：A[0]=A[1]=0,A[2]=1
 */
public class numberOfArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int len=A.length;
        int n=len-2;
        int sum=0;
        for (int i = 1; i <=n ; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test={1, 2, 3, 4};
        int ans=new numberOfArithmeticSlices_413().numberOfArithmeticSlices(test);
        System.out.println(ans);
    }
}
