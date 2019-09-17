package com.Solution.Top100;

import java.util.Stack;

public class longestValidParentheses_32_最长有效括号 {
    /**
     * 思路1
     * 首先想到的思路，用栈和dp数组来实现
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack();
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            if (cur == '(')
                st.push(i);
            else {
                if (st.isEmpty())
                    continue;
                else {
                    int preindex = st.pop();
                    dp[i] = dp[preindex - 1] + i - preindex + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }


    /**
     * 思路2：不借用额外空间
     * 遍历两遍字符串
     * 第一次从左到右
     * 第二次从右到左
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') left++;
            else right++;
            if (left < right) {
                left = 0;
                right = 0;
                continue;
            }
            if (left == right) max = Math.max(max, left + right);
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '(') left++;
            else right++;
            if (left > right) {
                left = 0;
                right = 0;
                continue;
            }
            if (left == right) max = Math.max(max, left + right);
        }

        return max;
    }
}
