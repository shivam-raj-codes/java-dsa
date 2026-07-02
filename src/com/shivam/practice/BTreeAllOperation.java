package com.shivam.practice;

public class BTreeAllOperation {

    // root as global variable
    private Node root;

    public static class Node {
        Node left;
        Node right;
        int val;

        public Node (int val) {
            this.val = val;
        }
    }


    // insert
    public void insert(int val) {
        root = insert(val, root);
    }
    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.val) {
            node.left = insert(val, node.left);
        }
        else {
            node.right = insert(val, node.right);
        }

        return node;
    }

    public void populate(int[] arr) {
        for (int i : arr) {
            insert(i);
        }
    }

    // traversal
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) return;


        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    // height
    public int height() {
        if (root == null) {
            return 0;
        }
        return height(root);
    }
    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1; // bottom to top approach
    }

    // display
    public void display() {
        display(root, 0);
    }
    private void display(Node node, int level) {

        if (node == null) {
            return;
        }

        // go right
        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        }
        else {
            System.out.println(node.val); // to display the root
        }

        display(node.left, level + 1);
    }

    // searching
    public boolean isFound(int target) {
        return isFound(root, target);
    }
    private boolean isFound(Node node, int target) {
        if (node == null) {
            return false;
        }


        if (target == node.val) {
            return true;
        }
        if (target < node.val) {
            return isFound(node.left, target);
        }
        else {
            return isFound(node.right, target);
        }

    }

    // min - val of BST
    public int findMin() {
        if (root == null) {
            return -1;
        }
        return findMin(root);
    }

    private int findMin(Node node) {
        if (node.left == null) {
            return node.val;
        }
        return findMin(node.left);
    }

    public static void main(String[] args) {
        int[] arr = {15, 8, 10, 17, 16, 4, 18};

        BTreeAllOperation bt = new BTreeAllOperation();
        bt.populate(arr);

        bt.display();
        System.out.println("\nInOrder - Traversal: ");
        bt.inOrder();
        System.out.println("\nPreOrder - Traversal: ");
        bt.preOrder();
        System.out.println("\nPostOrder - Traversal: ");
        bt.postOrder();

        int height = bt.height();
        System.out.println("\nHeight of BST: " + height);

        boolean result = bt.isFound(16);
        System.out.println(result);

        int miN = bt.findMin();
        System.out.println("Minimum Node value in BST: " + miN);
    }
}
