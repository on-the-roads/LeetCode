package com.Solution.Top100;

public class isMatch_10_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        return trace(s, 0, p, 0);
    }


    /**
     * 针对字符串s和p设置两个指针sindex和pindex，都从0开始向后遍历，根据p[index+1]是否为'*'分为两种情况
     * （1）p[index+1]不是‘*’，则只有s[sindex]==p[index]或者p[index]==‘.’时两个指针才能继续向后遍历
     * （2）p[index+1]是‘*’，则‘*’可能匹配0次，1次或者多次
     * （2.1） s[sindex]!=p[index]时只能匹配0次
     * （2.2）s[sindex]==p[index]或者p[index]==‘.’时，可以匹配0次，1次或者多次
     *
     * @param s
     * @param sindex
     * @param p
     * @param pindex
     * @return
     */
    private boolean trace(String s, int sindex, String p, int pindex) {
        if (sindex >= s.length() && pindex >= p.length()) return true;
        if (sindex < s.length() && pindex >= p.length()) return false;
        if (pindex < p.length() - 1 && p.charAt(pindex + 1) == '*') {
            if (sindex < s.length() && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.'))
                return trace(s, sindex, p, pindex + 2) || trace(s, sindex + 1, p, pindex + 2) || trace(s, sindex + 1, p, pindex);
            else {
                return trace(s, sindex, p, pindex + 2);   //这种情况就包含了s可能为空串的可能。
            }
        } else {
            if (sindex < s.length() && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.'))
                return trace(s, sindex + 1, p, pindex + 1);
            return false;
        }
    }
}
