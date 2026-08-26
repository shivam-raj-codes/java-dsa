package com.shivam.heaps;

import java.util.ArrayList;

public class HeapDS<T extends Comparable<T>> {

    private ArrayList<T> list;

    public HeapDS() {
        list = new ArrayList<>();
    }

    // swap 2 - indices in ArrayList
    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2 + 1);
    }

    private int right(int index) {
        return (index * 2 + 2);
    }

    public void insert(T value) {
        list.add(value); /// will add value at last
        // try to swap from bottom to above
        upheap(list.size() - 1);
    }

    private void upheap(int index) {

        // base - case
        if (index == 0) {
            return;
        }

        /// get parent's - index
        int p = parent(index);

        if (list.get(index).compareTo(list.get(p)) < 0) {
            // if current item(index) is smaller than Parent => SWAP
            swap(index, p);

            upheap(p); // now next going to check for parent(P)
        }
    }

    public void populate(T[] arr) {
        for (T i : arr) {
            insert(i);
        }
    }
    public void display() {
        System.out.println(list);
    }

    public void displayTree() {
        displayTree(0, 0);
    }

    private void displayTree(int index, int level) {
        if (index >= list.size()) {
            return;
        }

        // Print right subtree first
        displayTree(right(index), level + 1);

        if (level != 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + list.get(index));
        }
        else {
            System.out.println(list.get(index));
        }

        // Print left subtree
        displayTree(left(index), level + 1);
    }


    //------Remove--------
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an Empty heap");
        }

        // getting item from 0th - index
        T temp = list.getFirst();

        T last = list.remove(list.size() - 1); /// take ele from last
        if (!list.isEmpty()) {
            list.set(0, last); /// insert last - taken ele to 0th

            downHeap(0);
        }

        return temp;
    }

    private void downHeap(int index) {
        int min = index;

        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        /// means we've found that either Left or Right one of those is smaller than current item => SWAP & call downHeap(with that swaped element Index => with new min - idx, After Swap)
        if (min != index) {
            swap(min, index);

            downHeap(min);
        }
    }


    // ------------Heap Sort----------

    /// Heap Sort works because the Tree is rebuilt after every removal.
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }



    ///  main - fn
    public static void main(String[] args) throws Exception{
        HeapDS<Integer> heap = new HeapDS<>();
        Integer[] arr = {7, 8, 9, 10, 11, 12, 14, 13, 5};

        heap.populate(arr);

        ///  to see output
        //because list is private.
        heap.display(); // fetch through fn

        heap.displayTree(); /// display like Complete Binary-Tree

        ArrayList<Integer> list = heap.heapSort();
        System.out.println("SortedList: " +list);
    }
}
