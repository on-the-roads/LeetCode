package com.Solution.String;

/**
 * 题目：给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 思路：
 * 思路1：最容易想到的思路(时间复杂度O(n^2))
 * 当最开始的位置值为1时，就向后遍历，统计连续有多少个1（num_1），然后统计有多少个0（num_0）,当num_0>=num_1时说明是一个有效的子串。
 * 当最开始的位置值为0时，就向后遍历，统计连续有多少个0（num_0），然后统计有多少个1（num_1）,当num_1>=num_0时说明是一个有效的子串。
 * 最开始的位置从数组的第一位一直遍历到倒数第二位。
 * <p>
 * 思路2：(时间复杂度为O(n))
 * 注意该题的规律，设置两个变量prelen和curlen,prelen用来保存上次连续数的个数，curlen用来保存当前连续数的个数。
 * 规律：prelen>=curlen时就会产生有效子串，例如“1100”中就有两个有效子串“10”和“1100”
 */
public class countBinarySubstrings_696 {
    /**
     * 思路1
     * @param args
     */
//    public int countBinarySubstrings(String s) {
//        int ans = 0;
//        for (int i = 0; i < s.length()-1; i++) {
//            ans += Count(s, i);
//        }
//        return ans;
//    }
//
//    private int Count(String s, int start) {
//        if (start >= s.length() - 1)
//            return 0;
//        int i = start;
//        int num_0 = 0;
//        int num_1 = 0;
//        if (s.charAt(i)=='1') {//当最开始的位置值为1时
//            while ( i < s.length()&&s.charAt(i) == '1' ) {
//                num_1++;//向后遍历，统计连续有多少个1（num_1）
//                i++;
//            }
//            while ( i < s.length()&&s.charAt(i) == '0' ) {
//                num_0++;//向后遍历，统计连续有多少个0（num_0）
//                if (num_0 == num_1)
//                    return 1;
//                i++;
//            }
//            return 0;
//        } else {//当最开始的位置值为0时
//            while (i < s.length()&&s.charAt(i) == '0') {
//                num_0++;//向后遍历，统计连续有多少个0（num_0）
//                i++;
//            }
//            while (i < s.length()&&s.charAt(i) == '1') {
//                num_1++;//向后遍历，统计连续有多少个1（num_1）
//                if (num_0 == num_1)
//                    return 1;
//                i++;
//            }
//            return 0;
//        }
//    }


    /**
     * 思路2
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int curlen = 1;
        int prelen = 0;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                curlen++;//curlen用来保存当前连续数的个数。
            else {
                prelen = curlen;//prelen用来保存上次连续数的个数，
                curlen = 1;
            }
            if (prelen >= curlen)//prelen>=curlen时就会产生有效子串
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int ans1 = 0;
        int ans2 = 0;
        countBinarySubstrings_696 count = new countBinarySubstrings_696();
        ans1 = count.countBinarySubstrings("00110011");
        ans2 = count.countBinarySubstrings("10101");
        System.out.println(ans1 + " " + ans2);
    }
}
