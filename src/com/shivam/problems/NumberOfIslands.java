package com.shivam.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                /// land and not visited
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }

        return cnt;
    }

    public static void bfs(int r, int c, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delR = {-1, 0, +1, 0};
        int[] delC = {0, +1, 0, -1};

        vis[r][c] = 1; /// marks as vis

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.first;
            int col = p.second;

            // check for neighbour
            for (int i = 0; i < 4; i++) {
                int nRow = row + delR[i];
                int nCol = col + delC[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == '1' && vis[nRow][nCol] != 1) {

                    queue.offer(new Pair(nRow, nCol)); /// neighbour goes into Queue

                    vis[nRow][nCol] = 1; /// marks as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(arr));
    }
}
