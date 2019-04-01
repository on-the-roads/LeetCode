package com.Solution.dynamic_programming;


/**
 * 题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？注意：给定 n 是一个正整数
 * 思路：动态规划
 */
public class climbStairs_70 {

    //方法1：空间复杂度为O(n)
//    public int climbStairs(int n) {
//        int[] arr=new int[n+1];
//        arr[0]=1;
//        arr[1]=1;
//        for (int i = 2 ; i <=n; i++) {
//            arr[n]=arr[n-1]+arr[n-2];
//        }
//        return arr[n];
//    }

    //方法2，空间复杂度为O(1)
    public int climbStairs(int n) {

        if (n <= 1)
            return 1;
        int num1 = 1;
        int num2 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = num1 + num2;
            num1 = num2;
            num2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new climbStairs_70().climbStairs(3);
        System.out.println(ans);
    }
}
