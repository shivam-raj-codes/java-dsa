package com.shivam.trees;

public class BST {
    public static class Node {
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node(int value) { // constructor to Initialize
            this.value = value;
        }

        // getValue
        public int getValue() {
            return value;
        }
    }

    private Node root; // setting root - Node

    // constructor
    public BST() {

    }

    // calculate height
    public int height(Node node) {
        if (node == null) { // empty tree
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // To insert
    public void insert(int value) {
        root = insert(value, root); // in the end root is returned so we assign it to root again
    }

    private Node insert(int value, Node node) {

        if (node == null) { // when we found(current) null means insert there
            // create newNode by reusing Parameter "node" and return thet
            node = new Node(value);
            return node;

        }

        if (value < node.value) { // go to left
            node.left = insert(value, node.left);
        }

        if (value > node.value) { // go to right
            node.right = insert(value, node.right);
        }


        // while traversing back => old height + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node; //🌟Now traversing back-> return whatever current we have if not inserter newNode returned existing node that already attach else returned newLy inserted Node
    }

    // To insert multiple item

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]); // call insert fun for every item in array
        }
    }


    // as We have height Can check for balanced or Not

    public boolean balanced() {
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if (node == null) { // => there is no tree -> True
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right); // lly, checking height difference for left tree and right tree using and(&&)
    }

    // display Node with there info
    public void display() {

        display(this.root, "Root Node: ");

    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value); // display: details: value
        // now goes to LHS and display value with info
        display(node.left,"Left of " + node.value + " : ");

        // lly, goes to RHS and display
        display(node.right,"Right of " + node.value + " : ");
    }

    // pretty printing
    public void prettyDisplay() {

        prettyDisplay(root, 0);

    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }


    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {15, 30, 6, 4, 7, 3, 18, 17};
        tree.populate(arr);

        // display
        tree.display();

        tree.prettyDisplay();
    }
}
