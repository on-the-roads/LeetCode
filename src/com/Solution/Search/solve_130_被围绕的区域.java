package com.Solution.Search;

/**
 * 题目：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 思路：DFS，
 * （i）在矩阵的边界找‘O’，找到后从该位置进行DFS查找所有与该‘O’相连通的‘O’，并标记已访问
 * （ii）对二维矩阵进行遍历，查找所有未标记的‘O’，将其替换为‘X’。
 * <p>
 * 优化：
 * 不开辟新的二维数组作为访问标志，可以直接将（i）中的‘O’替换为其他字母，比如‘T’
 * 在第（ii）中再将‘T’替换为‘O’，节省了空间。
 */
public class solve_130_被围绕的区域 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O' && !visited[0][col])
                dfs(board, 0, col, visited);
            if (board[rows - 1][col] == 'O' && !visited[rows - 1][col])
                dfs(board, rows - 1, col, visited);
        }
        for (int row = 1; row < rows - 1; row++) {
            if (board[row][0] == 'O' && !visited[row][0])
                dfs(board, row, 0, visited);
            if (board[row][cols - 1] == 'O' && !visited[row][cols - 1])
                dfs(board, row, cols - 1, visited);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
        return;
    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col])
            return;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(board, row + dir[0], col + dir[1], visited);
        }
        return;
    }

    public static void main(String[] args) {
        char[][] test = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new solve_130_被围绕的区域().solve(test);
    }
}
