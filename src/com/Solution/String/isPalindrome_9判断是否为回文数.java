package com.Solution.String;

/**
 * 题目：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 思路：由于要求不能开辟新的空间，不能转换为字符串，所以就要从数字本身入手。
 * 将数字分为两部分，后一部分进行翻转判断两数是否相同。
 */
public class isPalindrome_9判断是否为回文数 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x!=0&&x%10==0)
            return false;
        int right=0;//将数的右半部分进行翻转
        while(x>right)
        {
            right=right*10+x%10;
            x=x/10;
        }
        return x==right||x==right/10;//数字位数为偶数或者奇数的情况进行相等判断
    }

    public static void main(String[] args) {
        boolean ans1=new isPalindrome_9判断是否为回文数().isPalindrome(-11);
        boolean ans2=new isPalindrome_9判断是否为回文数().isPalindrome(11);
        boolean ans3=new isPalindrome_9判断是否为回文数().isPalindrome(121);
        boolean ans4=new isPalindrome_9判断是否为回文数().isPalindrome(0);
        System.out.println(ans1+" "+ans2+" "+ans3+" "+ans4);
    }
}

