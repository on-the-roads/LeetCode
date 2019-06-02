package com.Solution.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 思路：n皇后的规则是，每一行，每一列，每一个对角线只能出现一个皇后，因此我们针对该规则建立三个布尔数组，运用回溯+剪枝的方法
 */
public class solveNQueens_51_N皇后 {
    private List<List<String>> res = new ArrayList<>();
    private int n;
    private char[][] chs;
    boolean[] colExist;//列
    boolean[] _45degExist;//45度对角线
    boolean[] _135degExist;//135度对角线

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        chs = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chs[i], '.');
        }
        if (n <= 0)
            return res;
        this.colExist = new boolean[n];//列
        this._45degExist = new boolean[2 * n - 1];//45度对角线
        this._135degExist = new boolean[2 * n - 1];//135度对角线
        trace(0);//从第一行开始
        return res;
    }

    private void trace(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] ch : chs) {
                list.add(new String(ch));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colExist[col] || _45degExist[row + col] || _135degExist[n - 1 - (row - col)])
                continue;
            chs[row][col] = 'Q';
            colExist[col] = true;
            _45degExist[row + col] = true;
            _135degExist[n - 1 - (row - col)] = true;
            trace(row + 1);
            chs[row][col] = '.';
            colExist[col] = false;
            _45degExist[row + col] = false;
            _135degExist[n - 1 - (row - col)] = false;
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = new solveNQueens_51_N皇后().solveNQueens(4);
    }
}
