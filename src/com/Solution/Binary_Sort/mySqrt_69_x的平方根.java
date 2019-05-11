package com.Solution.Binary_Sort;

/**
 * 题目：实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 *
 * 思路：
 *      思路1：自己想出来的做法，利用n^2=0+1+3+....+(2n-1)规律
 *      思路2：x的平方根一定在0~x之间，利用二分查找法来找出平方根
 */
public class mySqrt_69_x的平方根 {
    //思路1
    public int mySqrt1(int x) {
        double sum=0;
        int n=0;
        while(x>=sum)
        {
            sum+=2*n+1;
            n++;
        }
        return n-1;
    }

    public int mySqrt2(int x) {
        if(x<=1)
            return x;
        int l=0;
        int r=x;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            int sqrt=x/m;
            if(sqrt==m)
                return m;
            if(sqrt<m)
                r=m-1;
            else
                l=m+1;
        }
        return r;
    }


        public static void main(String[] args) {
        int ans=new mySqrt_69_x的平方根().mySqrt2(8);
        System.out.println(ans);
    }
}
