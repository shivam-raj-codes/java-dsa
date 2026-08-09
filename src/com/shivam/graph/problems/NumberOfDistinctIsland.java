package com.shivam.graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NumberOfDistinctIsland {
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (!visited[i][j] && grid[i][j] == '1') {

                    ArrayList<String> list = new ArrayList<>();
                    /// n x m x 4
                    dfs(i, j, grid, visited, list, i, j);

                    set.add(list);
                }

            }

        }
        ///  n x m x log(n x m) + (n x m x 4)
        return set.size(); /// No. of unique Island.
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited, ArrayList<String> list, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        list.add((row - row0) + "," + (col - col0)); /// add Co-Ordinates vy converting them into String

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            /// go to neighbour
            if (nRow >=0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                dfs(nRow, nCol, grid, visited, list, row0, col0);
            }
        }
    }
}

// space: O(n * m)
// Time: O(n x m x log(n x m) + (n x m x 4))
