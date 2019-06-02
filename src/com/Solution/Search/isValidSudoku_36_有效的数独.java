package com.Solution.Search;

/**
 * 题目：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 思路：由数独的约束条件来判断数独是否有效，新建三个数组，分别用来保存数字1-9 在每一行出现的次数，每一列出现的次数，以及每个子九宫格出现的次数，一旦大于等于2，则说明无效
 */
public class isValidSudoku_36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[][] columnCount = new int[10][9];
        int[][] rowCount = new int[10][9];
        int[][] subMatrixCount = new int[10][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (board[i][j] != '.' && (++rowCount[num][i] == 2 || ++columnCount[num][j] == 2 || ++subMatrixCount[num][i / 3 * 3 + j / 3] == 2))
                    return false;
            }
        }
        return true;
    }
}
