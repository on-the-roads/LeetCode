package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 * 思路：DFS，，逆向思维，从大陆的上和左边界探索能够到达太平洋的坐标，从下边界和右边界出发探索能够达到大西洋的坐标；
 * 如果用正向思维遍历每个坐标判断能不能达到太平洋和大西洋，较为麻烦，复杂度也较高，很可能栈溢出。
 *
 */
public class pacificAtlantic_417_太平洋大西洋水流问题 {
    private ArrayList<int[]> list = new ArrayList<>();
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] matrix;
    private int rows;
    private int cols;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        this.matrix=matrix;
        if (matrix == null || matrix.length == 0)
            return list;
        boolean[][] visited_pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] visited_Atlantic = new boolean[matrix.length][matrix[0].length];

        this.cols = matrix[0].length;
        this.rows = matrix.length;
        for (int col = 0; col < cols; col++) {
            dfs(0, col, visited_pacific);
            dfs(rows - 1, col, visited_Atlantic);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, visited_pacific);
            dfs(row, cols - 1, visited_Atlantic);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited_Atlantic[i][j] && visited_pacific[i][j])
                    list.add(new int[]{i, j});
            }
        }
        return list;
    }

    private void dfs(int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] d : dirs) {
            int nextR = d[0] + row;
            int nextC = d[1] + col;
            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols
                    || matrix[row][col] > matrix[nextR][nextC]) {
                continue;
            }
            dfs(nextR, nextC, visited);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<int[]> list = new pacificAtlantic_417_太平洋大西洋水流问题().pacificAtlantic(matrix);
    }
}
