package com.Solution.Search;

import java.util.LinkedList;

/**
 * 题目：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 思路：BFS，将完全平方数当成图的顶点， 从n出发，利用BFS算法找寻最短路径
 *         该题也可以用动态规划解决
 */
public class numSquares_279_完全平方数 {
    public int numSquares(int n) {
        LinkedList<Integer> squares = getSquares(n);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean visted[] = new boolean[n];
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int node = queue.poll();
                for (int square : squares) {
                    int cur = node - square;
                    if (cur < 0)
                        break;
                    if (cur == 0)
                        return count;
                    if (visted[cur] == true)
                        continue;
                    visted[cur] = true;
                    queue.add(cur);
                }
            }
        }
        return n;
    }

    //获得不大于n的所有完全平方数：1 4 9 ...
    private LinkedList<Integer> getSquares(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int gap = 1;
        int init = 1;
        while (init <= n) {
            list.add(init);
            gap += 2;
            init += gap;
        }
        return list;
    }


    public static void main(String[] args) {
        int ans = new numSquares_279_完全平方数().numSquares(12);
        System.out.println(ans);
    }
}
