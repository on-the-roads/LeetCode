package com.Solution.Math;

/**
 * 题目：给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 思路：
 * 做法1：首先想到的思路，两个字符串从后往前逐步相加，和除以2，商作为那一位的结果，余数作为进位数。最后将得到的字符串反转。
 * 做法2：思路同做法1，优化了代码
 */
public class addBinary_67_二进制求和 {
    public String addBinary1(String a, String b) {
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        int c = 0;//进位
        StringBuilder sb = new StringBuilder();
        while (a_index >= 0 && b_index >= 0) {
            int a_int = a.charAt(a_index) - '0';
            int b_int = b.charAt(b_index) - '0';
            int d = (a_int + b_int + c) % 2;
            c = (a_int + b_int + c) / 2;
            sb.append(d);
            a_index--;
            b_index--;
        }
        while (a_index >= 0) {
            int a_int = a.charAt(a_index) - '0';
            int d = (a_int + c) % 2;
            c = (a_int + c) / 2;
            sb.append(d);
            a_index--;
        }
        while (b_index >= 0) {
            int b_int = b.charAt(b_index) - '0';
            int d = (b_int + c) % 2;
            c = (b_int + c) / 2;
            sb.append(d);
            b_index--;
        }
        if (c != 0)
            sb.append(c);
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int carry=0;
        int a_index=a.length()-1;
        int b_index=b.length()-1;
        StringBuilder sb=new StringBuilder();
        while (carry==1||a_index>=0||b_index>=0)
        {
            if(a_index>=0&&a.charAt(a_index--)=='1')
                carry++;
            if(b_index>=0&&b.charAt(b_index--)=='1')
                carry++;
            sb.append(carry%2);
            carry=carry/2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "1";
        String ans = new addBinary_67_二进制求和().addBinary2(s1, s2);
        System.out.println(ans);
    }
}
