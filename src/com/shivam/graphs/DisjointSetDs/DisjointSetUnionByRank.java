package com.shivam.graphs.DisjointSetDs;

public class DisjointSetUnionByRank {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // is 3 & 7 belong to same component or not?
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        ds.unionByRank(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}

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