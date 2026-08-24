package com.shivam.graphs.algorithm;

public class FloodFillAlgorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int iniColor = image[sr][sc];

        // copy of given image-box
        int[][] ans = new int[image.length][];

        for (int i = 0; i < image.length; i++) {
            ans[i] = image[i].clone();
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        dfs(sr, sc, ans, iniColor, image, color, delRow, delCol);

        return ans;
    }

    private void dfs(int row, int col, int[][] ans, int iniColor, int[][] image, int newColor, int[] delRow, int[] delCol) {
        ans[row][col] = newColor; /// color it

        int n = image.length;
        int m = image[0].length;

        /// check for neighbour -> 4 neighbours

        for (int i = 0; i < 4; i++) {
            ///  get neighbour row & column
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            ///  ans[nRow][nCol] != newColor => if it doesn't have new color means previously not visited
            if (nRow >= 0 && nRow < n && nCol >=0 && nCol < m
                    && image[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor) {

                dfs(nRow, nCol, ans, iniColor, image, newColor, delRow, delCol);

            }
        }
    }

}
