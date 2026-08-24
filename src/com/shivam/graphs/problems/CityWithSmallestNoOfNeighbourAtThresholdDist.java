package com.shivam.graphs.problems;

import java.util.Arrays;

public class CityWithSmallestNoOfNeighbourAtThresholdDist {
    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        int INF = (int) 1e9;
        for (int[] i : dist) {
            Arrays.fill(i, INF);
        }

        // fill matrix
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0; /// itself to itself
        }

        // floyd Algo => gives me the shortest path from all source
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] == INF || dist[via][j] == INF) {
                        continue;
                    }
                    else {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }

                if (cnt <= cntCity) {
                    cntCity = cnt;
                    cityNo = city;
                }
            }
        }
         return cityNo;
    }
}

/// dist[city][city] = 0 is also counted.