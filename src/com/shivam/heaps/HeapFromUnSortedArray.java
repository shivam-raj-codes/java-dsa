package com.shivam.heaps;
import java.util.Collections;
import java.util.ArrayList;

// <...> → This is my generic type parameter declaration.
// Integer implements Comparable<Integer>
public class HeapFromUnSortedArray <T extends Comparable<T>> {

    ArrayList<T> list;

    public HeapFromUnSortedArray () {
        list = new ArrayList<>();
    }

    /// To swap two indices in List
    public void swap (int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second)); // at first put second
        list.set(second, temp);
    }


    ///  structure of Tree
    public int parent (int index) {
        return (index - 1) / 2;
    }

    public int left (int index) {
        return (index * 2) + 1;
    }

    public int right (int index) {
        return (index * 2) + 2;
    }

    public void insert(T[] arr) {
        Collections.addAll(list, arr);

        ///  dowHeap from Non-leaf A/c to CBT - property (Current parent. Does it need to go down?)
        for (int i = list.size() / 2 - 1; i >= 0; i--) { // from non leaf to 0th index => Checking is parent need to go down?
            downHeap(i);
        }
    }

    public void downHeap(int index) {

        int max = index; /// Assume current index => (Parent) is Max

        int leftChild = left(index);
        int rightChild = right(index);

        /// Agar left child parent se bada hai, to max ko left child bana do.
        if(leftChild < list.size() && list.get(max).compareTo(list.get(leftChild)) < 0) {

            max = leftChild;

        }

        /// Ab compare parent se nahi, ab tak ke largest se kar rahe ho.
        if (rightChild < list.size() && list.get(max).compareTo(list.get(rightChild)) < 0) {

            max = rightChild;

        }

        ///  is parent(i.e; index is Not Largest) => then call Else Stop
        if (max != index) {

            /// swap (index, ({with Largest Among left, right & parent(i.e; index)}) => max)
            swap(max, index);

            downHeap(max); /// Continue from there
        }
    }

   /*
     important Notes 🌟:
     DownHeap()

     index = current node (parent) we are checking.
     Find the largest among parent, left, and right.
     If parent is not the largest:
     Swap parent with the largest child.
     Parent element has now moved down.
     Call downHeap() on the new position of the parent (max).

   🌟Memory Trick:

   "Fix the current parent, then follow the element that moved down."
    */


    // ------------------ doing with upHEap ----------

    public void insert2(T[] arr) {

        list.clear();   // <-- important

        for (T i : arr) {
            list.add(i);

            ///  inserting one - by - one and Check violation?
            upHeap(list.size() - 1); // passing index of last-inserted Elem
        }
    }

    /// upHeap => Min-Heap
    public void upHeap(int index) {

        // when index == 0, you've reached the root. There is no parent above it.
        if (index == 0) {
            return;
        }

        // get parent-index of inserted - elem
        int p = parent(index);

        if(list.get(index).compareTo(list.get(p)) < 0) {

            ///  inserted - ele < parent(inserted - el) => Swap both
           swap(index, p);

           /// As parent position change => now check is parent at correct posi Or further need to swap => call upHeap(parent)

           upHeap(p);
        }
    }


    ///  display - fn
    public void display(String message) {
        System.out.println(message +  list);
    }

    public static void main(String[] args) {
        HeapFromUnSortedArray<Integer> heap = new HeapFromUnSortedArray<>();

        Integer[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        ///  down - Heap
        heap.insert(arr);

        heap.display("Max-Heap from UnSorted Array: ");

        /// up - heap
        heap.insert2(arr);
        heap.display("Min-Heap from UnSorted Array: ");
    }
}
