package com.shivam.heaps.questions;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    static class Pair {
        int distance;
        int x;
        int y;

        public Pair(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }

    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.distance, a.distance));
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int distance = (x * x) + (y * y); /// calculate distance

            maxHeap.offer(new Pair(distance, x, y));

            if (maxHeap.size() > k) {
                // Keep only the k closest points
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // ============ forming Answer array ===============

        // every row always has exactly 2 columns:
        // Column 0 → x
        // Column 1 → y
        int[][] ans = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();

            int X = p.x; // point - x
            int Y = p.y; // point - y

            ans[i][0] = X;
            ans[i][1] = Y;

            i++;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };

        int k = 2;

        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }
}
