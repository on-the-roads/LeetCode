package com.Solution.Search;

/**
 * 题目：给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 思路：DFS
 */
public class maxAreaOfIsland_695_岛屿的最大面积 {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                max = Math.max(max, getMinPath(grid, i, j, visited));
            }
        }
        return max;
    }

    private int getMinPath(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0)
            return 0;
        visited[row][col] = true;
        int path = 1;
        for (int[] dir : dirs) {
            path += getMinPath(grid, row + dir[0], col + dir[1], visited);
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        int ans = new maxAreaOfIsland_695_岛屿的最大面积().maxAreaOfIsland(grid);
        System.out.println(ans);
    }
}
