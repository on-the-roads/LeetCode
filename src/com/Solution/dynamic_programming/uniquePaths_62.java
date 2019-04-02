package com.Solution.dynamic_programming;

/**
 * 题目：一个机器人位于一个 n x m 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */
public class uniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int row = n;
        int col = m;
        int[][] ans = new int[row][col];

        for (int i = 0; i < col; i++) {
            ans[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            ans[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int ans=new uniquePaths_62().uniquePaths(7,3);
        System.out.println(ans);
    }

}

