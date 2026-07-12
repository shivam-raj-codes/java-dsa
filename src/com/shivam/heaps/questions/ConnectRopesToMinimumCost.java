package com.shivam.heaps.questions;

import java.util.PriorityQueue;

public class ConnectRopesToMinimumCost {

    static int connectRopes(int[] ropes) {
        // declared Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // forms heap with all ropes length
        for(int rope : ropes) {
            minHeap.offer(rope);
        }

        int cost = 0;
        while (minHeap.size() >= 2) {
            int firstRope = minHeap.poll();
            int secondRope = minHeap.poll();

            cost += firstRope + secondRope;

            int connectedRope = firstRope + secondRope; // two current minimum length ropes is connected

            minHeap.offer(connectedRope);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] ropes = {1, 2, 3, 4, 5};
        System.out.println(connectRopes(ropes));
    }
}
