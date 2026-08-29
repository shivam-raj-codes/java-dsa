package com.shivam.graphs.DisjointSetDs.problem;


import java.util.ArrayList;


class DisjointSet {
    int[] rank;
    int[] parent;

    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find ultimate parent + path compression
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }


        int ultimateParent = findUPar(parent[node]);
        parent[node] = ultimateParent; /// path compression

        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); /// ultimate parent of 'u'
        int ulp_v = findUPar(v); /// ultimate parent of 'v'

        /// Already in same component
        if (ulp_u == ulp_v) {
            return;
        }

        /// Smaller rank Tree goes below bigger rank Tree
        // as smaller guy connected to larger => no increment in height.
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            // Same rank → choose either as parent & height increases
            parent[ulp_v] = ulp_u;
            // v attach to u => u size++
            rank[ulp_u]++;
        }
    }
}

public class NoOfProvincesUsingDSU {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);

        /// iterate on adj - matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) {
                    // => edge b/w i & j
                    ds.unionByRank(i, j);
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (ds.findUPar(i) == i) {
                cnt++;
            }
        }
        return cnt; /// ans
    }
}