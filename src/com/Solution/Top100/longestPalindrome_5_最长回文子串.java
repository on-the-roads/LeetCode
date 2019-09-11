package com.Solution.Top100;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class longestPalindrome_5_最长回文子串 {

    /**
     * 思路1：利用动态规划思路
     * 创建二维布尔类型数组dp[i][j]用于表示 字符串的第i位到第j位组成的子串是否为回文子串。
     * 很明显:
     * (1)dp[i][i]=true;
     * (2)如果i=j-1,同时s.charAt(i) == s.charAt(j),dp[i][j]=true
     * (3)除去上述两种情况，s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]==true     则 dp[i][j] = true;
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] max = new int[2];
        int gap = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            for (int j = i; j < s.length(); j++) {
                if (i == j)
                    dp[i][j] = true;
                else if ((i == j - 1) && s.charAt(i) == s.charAt(j))
                    dp[i][j] = true;
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                    dp[i][j] = true;
                if (dp[i][j] && (j - i) > gap) {
                    gap = j - i;
                    max[0] = i;
                    max[1] = j;
                }
            }
        return s.substring(max[0], max[1] + 1);
    }

    /**
     * 思路2：相比思路1，空间复杂度为O(1)，时间复杂度为O(n^2)
     * 采用中心扩展的思想，对长度为n的字符串，一共存在2*n-1个扩展中心，因为回文字符串的长度可能为奇数也有可能为偶数
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLenPa(s, i, i);
            int len2 = getLenPa(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len >= (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLenPa(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
