package com.shivam.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Given n tasks numbered from 0 to n - 1 and a list of p prerequisite pairs pre[][], where each pair [a, b] means that
// task B must be completed before task A, determine whether it is possible to complete all the tasks.
public class PrerequisiteTasks {
    public boolean isPossible(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : pre) {
            int u = edge[0]; // first vertices
            int v = edge[1]; // second vertices

            adj.get(u).add(v);
        }

        // TopoSort:-
        ///  in - Degree
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            /// all vertex with inDeg = 0 : put in Queue
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>(); /// topo-Sort
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo.add(node); /// add in list

            /// node is in your topo-Sort
            /// so, please remove it from the inDegree[]
            for (int it: adj.get(node)) {
                inDegree[it]--; /// remove from inDegree[].
                if (inDegree[it] == 0) {
                    /// after removing, the inDegree of 'it' becomes-> 0
                    /// => have one more ele to put in topoSort
                    q.offer(it);
                }
            }
        }

        ///  if my ordering contains all the vertices => was not the Cycle => all task done with Prerequisite.
        if (topo.size() == n) {
            return true;
        }
        return false;
    }
}
