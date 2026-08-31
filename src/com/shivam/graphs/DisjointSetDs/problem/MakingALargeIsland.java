package com.shivam.graphs.DisjointSetDs.problem;

import java.util.HashSet;

// https://takeuforward.org/plus/dsa/problems/making-a-large-island
public class MakingALargeIsland {
    public class DisJointSet {
        int[] size;
        int[] parent;

        public DisJointSet(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findUPar (int node) {
            if (node == parent[node]) {
                return node;
            }

            int ulp = findUPar(parent[node]);

            parent[node] = ulp;   /// 🌟 path compression

            return ulp;
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if (ulp_u == ulp_v) {
                /// if they belonged to same component I don't need it
                return;
            }

            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v; // add smaller into larger => smaller parent now as same as larger parent.
                size[ulp_v] = size[ulp_v] + size[ulp_u];
            }
            else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] = size[ulp_u] + size[ulp_v];
            }
        }
    }

    private boolean isValid(int newR, int newC, int n) {
        return newR >=0 && newR < n && newC >= 0 && newC < n;
    }

    public int largestIsland(int[][] grid) {
        /// n x n grid
        int n = grid.length;
        DisJointSet ds = new DisJointSet(n * n);

        /// step1: connecting components.
        // traverse in grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;

                // 4 - direction
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};

                for (int i = 0; i < 4; i++) {
                    /// adjacent node
                    int newR = row + dr[i];
                    int newC = col + dc[i];

                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int nodeNo = row * n + col; /// u
                        int adjNodeNo = newR * n + newC; /// v
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        /// step2: Brute force convert every 0 -> 1.
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;

                // 4 - direction
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};

                HashSet<Integer> components = new HashSet<>();

                for (int i = 0; i < 4; i++) {
                    /// adjacent node
                    int newR = row + dr[i];
                    int newC = col + dc[i];

                    if (isValid(newR, newC, n)) {
                        if (grid[newR][newC] == 1) {

                            int cellNo = newR * n + newC;
                            components.add(ds.findUPar(cellNo));

                        }
                    }
                }

                int sizeTotal = 0;
                // traverse across set
                for (Integer parent : components) {
                    sizeTotal += ds.size[parent]; /// size of ulp
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }

        /// edge case: if the grid has no 0
        // as If there is no 0, entire grid is already one island
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size[ds.findUPar(cellNo)]);
        }

        return max;
    }
}
