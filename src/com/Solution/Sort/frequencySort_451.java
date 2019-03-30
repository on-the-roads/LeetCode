package com.Solution.Sort;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 题目：给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 思路:构造链表数组，数组下标为字符出现次数，链表中存放字符
 */
public class frequencySort_451 {
    public String frequencySort(String s) {
        //HashMap存放字符出现次数
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //链表数组实现桶
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];

        //将map中的字符与出现次数存储在bucket中
        for (Character key : map.keySet()) {
            if (bucket[map.get(key)] == null)
                bucket[map.get(key)] = new ArrayList<>();
            bucket[map.get(key)].add(key);
        }

        //从桶集中取字符
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String ans=new frequencySort_451().frequencySort("tree");

    }
}
