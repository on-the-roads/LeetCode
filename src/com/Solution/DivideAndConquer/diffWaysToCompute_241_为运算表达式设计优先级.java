package com.Solution.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 思路：分治，首先遍历字符串找到符号，根据符号的位置将字符串拆分为两部分（【分】），对每一部分继续如此（【治】），最终分的结果是两个数和一个符号，
 * 计算结果后向上层返回，再根据上一层符号进行具体的运算，一直向上层递进最终得到结果。
 */
public class diffWaysToCompute_241_为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '*' || temp == '-' || temp == '+') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left)
                    for (int r : right) {
                        switch (temp) {
                            case '+':
                                list.add(l+r);
                                break;
                            case '-':
                                list.add(l-r);
                                break;
                            case '*':
                                list.add(l*r);
                                break;
                        }
                    }
            }
        }
        if(list.size()==0)
            list.add(Integer.valueOf(input));
        return list;
    }


    public static void main(String[] args) {
        List<Integer> ans=new diffWaysToCompute_241_为运算表达式设计优先级().diffWaysToCompute("2-1-1");
    }
}
