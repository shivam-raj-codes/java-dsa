package com.shivam.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {

    private static class Pair {
        int row, col;

        public Pair(int row , int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int cntOnes(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0]. length;

        boolean[][] visited = new boolean[n][m];

        // first row & last row
        for (int j = 0; j < m; j++) {
            // first row
            if (!visited[0][j] && grid[0][j] == 1) {
                visited[0][j] = true;
                q.offer(new Pair(0, j));
            }
            // first col
            if (!visited[n - 1][j] && grid[n - 1][j] == 1) {
                visited[n - 1][j] = true;
                q.offer(new Pair(n - 1, j));
            }
        }

        // first col & last coln

        for (int i = 0; i < n; i++) {
            // first col
            if (!visited[i][0] && grid[i][0] == 1) {
                visited[i][0] = true;
                q.offer(new Pair(i, 0));
            }
            // last col
            if (!visited[i][m - 1] && grid[i][m - 1] == 1) {
                visited[i][m - 1] = true;
                q.offer(new Pair(i, m - 1));
            }
        }

        return bfs(grid, visited, q);
    }

    private int bfs(int[][] grid, boolean[][] visited, Queue<Pair> q) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Space: O(n * m)

// Time: O(n * m)