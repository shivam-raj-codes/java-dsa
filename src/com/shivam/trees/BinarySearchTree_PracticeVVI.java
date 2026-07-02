package com.shivam.trees;

public class BinarySearchTree_PracticeVVI {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(value, root); // after insertion of newNode at the end of insertion return root always contain root address
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            // go to left & insert in left and also return the New - attached node reference to your Parent
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            // go to right & insert there and also return the New - attached node reference to your Parent
            node.right = insert(value, node.right);
        }

        // if nothing is being inserted current node itself being returned
        return node;
    }


    public void populate (int[] arr) {
        for(int i : arr) {
            insert(i);
        }
    }



    // ⚠️🌟 for Each node think About what should one node return??
    //total count of nodes below me including me

    // Counting Total Node
    public int countNode() {
        return countNode(root);
    }
    private int countNode(Node node) {
        if (node == null) {
            return 0;
        }

        int left = countNode(node.left);
        int right = countNode(node.right);

        //🌟 vvi
//        Leaf node returns 1
//        null returns 0
//        parent adds both + itself
        return left + right + 1;
    }

    // display
    public void display() {
        display(root, 0);
    }
    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        }
        else {
            System.out.println(node.value); // to print root - node at level - 0
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        BinarySearchTree_PracticeVVI t = new BinarySearchTree_PracticeVVI();
        int[] arr = {15, 8, 10, 17, 16, 4, 18};

        t.populate(arr);
        t.display();

        System.out.println("\n" + t.countNode());
    }

}


// Flow of program during insertion
/*
null found
→ create new node
→ return to parent
→ parent attaches it
→ parent returns itself
→ continues till root
*/
