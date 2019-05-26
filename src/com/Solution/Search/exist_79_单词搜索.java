package com.Solution.Search;

/**
 * 题目：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 思路：DFS
 */
public class exist_79_单词搜索 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || word == null | word.length() == 0)
            return false;
        char c = word.charAt(0);
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c && dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (board[i][j] != word.charAt(index))
            return false;
        if (index == word.length() - 1 && board[i][j] == word.charAt(word.length() - 1))
            return true;

        boolean flag = false;
        visited[i][j] = true;
        for (int[] d : dirs) {
            int nextr = i + d[0];
            int nextc = j + d[1];
            if (nextr < 0 || nextr >= board.length || nextc < 0 || nextc >= board[0].length || visited[nextr][nextc])
                continue;

            flag = flag || dfs(board, nextr, nextc, word, index + 1, visited);
        }
        visited[i][j] = false;

        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        boolean ans = new exist_79_单词搜索().exist(board, word);
        System.out.println(ans);
    }

}
