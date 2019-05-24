package com.Solution.Search;

/**
 * 题目：班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 思路:DFS
 */
public class findCircleNum_547_朋友圈 {
    private int rows = 0;
    private int cols = 0;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        rows = M.length;
        int count = 0;
        boolean[] visited = new boolean[rows];
        for (int i = 0; i < rows; i++) {
            if (!visited[i])//第i个人之前没有访问过则进行dfs搜索
            {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int i, boolean[] visited) {
        cols = m[0].length;
        visited[i] = true;
        for (int j = 0; j < cols; j++) {
            if (i == j)
                continue;
            if (m[i][j] == 1 && !visited[j])
                dfs(m, j, visited);
        }
        return;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int ans = new findCircleNum_547_朋友圈().findCircleNum(grid);
        System.out.println(ans);
    }
}
