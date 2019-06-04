package com.Solution.DoublePoints;

/**
 * 题目：给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 思路：首先找到c的算术平方根作为右指针，0作为左指针，通过将平方和与target作比较使得两个指针向中间移动
 */
public class judgeSquareSum_633_平方数之和 {
    public boolean judgeSquareSum(int c) {
        int i=0;
        int j=(int)Math.sqrt(c);
        int sum=0;
        while(i<=j){
            sum=i*i+j*j;
            if(sum==c)
                return true;
            if(sum<c)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans=new judgeSquareSum_633_平方数之和().judgeSquareSum(1);
        System.out.println(ans);
    }
}
