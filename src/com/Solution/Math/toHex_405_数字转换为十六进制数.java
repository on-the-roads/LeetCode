package com.Solution.Math;

/**
 * 题目：给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 */
public class toHex_405_数字转换为十六进制数 {
    private final char[] dictionary={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num==0)
            return "0";
        StringBuilder sb=new StringBuilder();
        while (num!=0)
        {
            sb.append(dictionary[num&0b1111]);
            num>>>=4;//无符号右移
        }
        return sb.reverse().toString();
    }


}
