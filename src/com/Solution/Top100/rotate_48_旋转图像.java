package com.Solution.Top100;

public class rotate_48_旋转图像 {
    private static boolean[][] flag;
    private int rows;

    /**
     * 思路1
     * 首先想到的思路，该题最重要的部分就是找出新旧位置的映射关系
     * <p>
     * 旧: i,j-> 新：j，rows-i-1
     * 新: i,j-> 旧： rows-1-j,i
     *
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        this.rows = matrix.length;
        int cols = matrix[0].length;
        this.flag = new boolean[rows][cols];
        for (int i = 0; i <= (rows - 1) / 2; i++) {
            for (int j = i; j <= cols - 1 - 1 - i; j++) {
                process(matrix, i, j, matrix[rows - 1 - j][i]);
            }
        }
    }

    private void process(int[][] arr, int i, int j, int pre) {
        if (flag[i][j]) return;
        flag[i][j] = true;
        int newval = arr[i][j];
        arr[i][j] = pre;
        int newrow = j;
        int newcol = rows - i - 1;
        process(arr, newrow, newcol, newval);
    }


    /**
     * 思路同上，对空间做了优化，空间复杂度O(1)
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i <= (rows / 2 - 1); i++)
            for (int j = i; j <= cols - 2 - i; j++) {
                int temp = matrix[rows - 1 - j][i];
                matrix[rows - 1 - j][i] = matrix[rows - 1 - i][rows - 1 - j];
                matrix[rows - 1 - i][rows - 1 - j] = matrix[j][rows - 1 - i];
                matrix[j][rows - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
    }

}
