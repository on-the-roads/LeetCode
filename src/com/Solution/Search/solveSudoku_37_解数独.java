package com.Solution.Search;

/**
 * 题目：编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 思路：在题目36判断是否为有效数独的基础上--回溯+剪枝
 */
public class solveSudoku_37_解数独 {
    private boolean[][] rowExist = new boolean[10][9];
    private boolean[][] colExist = new boolean[10][9];
    private boolean[][] subMatrixExist = new boolean[10][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                rowExist[num][i] = true;
                colExist[num][j] = true;
                subMatrixExist[num][i / 3 * 3 + j / 3] = true;
            }
        }
        trace(board, 0, 0);
    }

    private boolean trace(char[][] board, int row, int col) {
        //过滤到有数字的空格，定位在‘.’处
        while (row < 9 && col < 9 && board[row][col] != '.') {
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }
        if (row == 9)
            return true;
        //定位在‘.’处
        for (int num = 1; num <= 9; num++) {
            if (rowExist[num][row] || colExist[num][col] || subMatrixExist[num][row / 3 * 3 + col / 3])
                continue;

            board[row][col] = (char) ('0' + num);
            rowExist[num][row] = true;
            colExist[num][col] = true;
            subMatrixExist[num][row / 3 * 3 + col / 3] = true;
            if (trace(board, row, col))
                return true;
            board[row][col] = '.';
            rowExist[num][row] = false;
            colExist[num][col] = false;
            subMatrixExist[num][row / 3 * 3 + col / 3] = false;
        }
        return false;
    }
}
