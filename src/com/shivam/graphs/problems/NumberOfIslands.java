package com.shivam.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && visited[row][col] != 1) {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }

        return count;
    }

    static void bfs(int row, int col, int[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        vis[row][col] = 1;
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();

            // traverse in neighbour
            // left, right, up, down
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {

                    // skip current cell
                    if (delRow == 0 && delCol == 0)
                        continue;

                    // skip diagonals
                    if (delRow != 0 && delCol != 0)
                        continue;

                    int newRow = r + delRow;
                    int newCol = c + delCol;

                    // check boundary and visit
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && vis[newRow][newCol] == 0) {
                        vis[newRow][newCol] = 1; /// mark as visited
                        q.add(new Pair(newRow, newCol)); /// add in queue
                    }
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
