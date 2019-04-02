package com.Solution.dynamic_programming;

/**
 * 题目：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 思路：定义一个mxn的路径矩阵res[][],res[i][j]表示走到从左上角走到[i][j]的最短路径和。
 */
public class minPathSum_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        for (int j = 1; j < col; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                int temp=grid[i][j];
                res[i][j]=Math.min(res[i-1][j]+temp,res[i][j-1]+temp);
            }
        }
        return res[row-1][col-1];
    }
}
