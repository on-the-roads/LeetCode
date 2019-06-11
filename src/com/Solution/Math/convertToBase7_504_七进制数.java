package com.Solution.Math;

/**
 * 题目：给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 思路：先用7整除整数，然后得到商和余数，StringBuilder中添加余数，然后在对商继续整除，循环直到商为0，然后对StringBuilder进行反转输出。
 */
public class convertToBase7_504_七进制数 {
    public String convertToBase7(int num) {
        StringBuilder sb=new StringBuilder();
        if(num==0)
            return "0";
        if(num<0)//如果是负数，就取相反数当做整数处理
            return "-"+convertToBase7(-1*num);
        while (num!=0){
            sb.append(num%7);
            num/=7;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String ans=new convertToBase7_504_七进制数().convertToBase7(-7);
        System.out.println(ans);
    }
}
