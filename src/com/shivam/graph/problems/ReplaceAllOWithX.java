package com.shivam.graph.problems;

// Problem Statement:
///The problem of replacing all 'O's with 'X's, often referred to as Surrounded Regions (LeetCode 130) or Replace O's with X's,
///requires converting only those 'O' regions that are completely enclosed by 'X's.  'O's that are on the board boundary or connected to a boundary 'O' must remain unchanged.

public class ReplaceAllOWithX {
    public static char[][] fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // del row & col
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][m];

        /// traverse 1st row & last row
        for (int j = 0; j < m; j++) {
            /// 1st - row
            if (!visited[0][j] && grid[0][j] == 'O') {
                dfs(0, j, grid, visited, delRow, delCol);
            }

            /// last - row
            if (!visited[n - 1][j] && grid[n - 1][j] == 'O') {
                dfs(n - 1, j, grid, visited, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            /// first coln
            if (!visited[i][0] && grid[i][0] == 'O') {
                dfs(i, 0, grid, visited, delRow, delCol);
            }

            ///  last coln
            if (!visited[i][m - 1] && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, grid, visited, delRow, delCol);
            }
        }

        /// traverse on entire grid[][]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'O') {
                    /// covert it into 'X'
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }

    /// dfs
    private static void dfs (int row, int col, char[][] grid, boolean[][] visited, int[] delRow, int[] delCol) {

        /// As dfs called => marks them as Visited.
        visited[row][col] = true;


        int n = grid.length;
        int m = grid[0].length;

        // check for Top, Right, Bottom & Left
        for (int i = 0; i <4 ; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == 'O') {
                dfs(nRow, nCol, grid, visited, delRow, delCol);
            }
        }
    }
}
