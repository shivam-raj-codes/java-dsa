package com.shivam.graph.problems;
import java.util.*;

// You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y]
// indicates that we need to take course  y first if we want to take course x.
//
//Find the ordering of courses we should take to complete all the courses.
//
//Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks
//return an empty array. The Driver code will print true if you return any correct order of courses else it will print false.
//
//Examples:
//
//Input: n = 3, prerequisites[][] = [[1, 0], [2, 1]]
//Output: true
//Explanation: To take course 1, you must finish course 0. To take course 2, you must finish course 1. So the only valid order is [0, 1, 2].
public class CourseScheduleII {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            // A/Q : The Pairs been reversed
            int u = edge[1]; // second vertices at first place
            int v = edge[0]; // first vertices at second place

            adj.get(u).add(v); /// second vertices at first place & first vertices at second place.
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

        ///  if my ordering contains all the vertices => was not the Cycle => returns all the topoSort Linear Ordering.
        if (topo.size() == n) {
            return topo;
        }
        return new ArrayList<>(); // return empty list

    }
}
