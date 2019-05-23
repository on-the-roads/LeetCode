package com.Solution.Search;

/**
 * 题目：给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 思路：DFS
 * 做法1：自己一开始想出来的思路
 * 做法2：对做法1进行了优化,将访问的‘1’直接设为‘0’，不用再创建一个boolean[][]数组存储访问标志了。
 */
public class numIslands_200_岛屿数量 {
    //做法1
    //    private int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
//    public int numIslands(char[][] grid) {
//        if(grid==null||grid.length==0)
//            return 0;
//        int count=0;
//        boolean[][] visited=new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(findPath(grid,visited,i,j))
//                    count++;
//            }
//        }
//        return count;
//    }
//
//    private boolean findPath(char[][] grid, boolean[][] visited, int i, int j) {
//        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j]||grid[i][j]=='0')
//            return false;
//        visited[i][j]=true;
//        for(int[] dir:dirs)
//            findPath(grid,visited,i+dir[0],j+dir[1]);
//        return true;
//    }

    //做法2
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for (int[] dir : dirs)
            dfs(grid, i + dir[0], j + dir[1]);
    }


    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int ans = new numIslands_200_岛屿数量().numIslands(grid);
        System.out.println(ans);
    }
}
