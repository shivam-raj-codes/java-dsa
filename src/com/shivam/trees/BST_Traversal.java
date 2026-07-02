package com.shivam.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST_Traversal {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node (int value) {
            this.val = value;
        }
    }

    // root - node
    private Node root;

    // insertion
    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {

        // base - case to make newNode and insert & return
        if (node == null) {
            node = new Node(value);
            return node; // after insertion of each newNode, new node is returned upward, and eventually the top call returns the root reference
        }

        if (value < node.val) {
            // go to left and insert
            node.left = insert(value, node.left);
        }

        if (value > node.val) {
            // go to right and insert
            node.right = insert(value, node.right);
        }
        return node;  // if new node not inserted return existing node
    }

    public void populate(int[] arr) {
        for (int i : arr) {
            insert(i);
        }
    }

    // Traversal ------->

    // inOrder => Lc, root, Rc
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        // go to left
        inOrder(node.left);

        System.out.print(node.val + " ");

        // go to right
        inOrder(node.right);
    }

    // preOrder => root, Lc, Rc
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");

        // go to left
        preOrder(node.left);

        // go to right
        preOrder(node.right);
    }

    // postOrder => Lc, Rc, root
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        // go to left
        postOrder(node.left);

        // go to right
        postOrder(node.right);

        System.out.print(node.val + " ");
    }

    // Searching
    public boolean search(int target) {
        return isFound(root, target);
    }
    private boolean isFound(Node node, int target) {
        if (node == null) {
            return false;
        }

        // found target
        if (target == node.val) {
            return true;
        }

        // go to left
        else if (target < node.val) {
            return isFound(node.left, target);
        }

        else {
            // go to right
            return isFound(node.right, target);
        }
    }

    // finding minimum element
    public int findMin() {
        if (root == null) {
            return -1; // tree not exist => No Min
        }
        return findMin(root, null);
    }
    private int findMin(Node node, Node prev) {

        // as we have BST so Min element will be at left bottom

        // base case
        if (node == null) {
            return prev.val;
        }

        prev = node; // 😁 prev will have info about one step back of current node
        return findMin(node.left, prev);
    }

    // display
    public void display() {
        display(root, 0);
    }
    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        // go to right
        display(node.right, level + 1);

        if (level != 0) {

            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }

            // at the end of loop after indentation print value
            System.out.println("|------>" + node.val);

        }

        else {
            System.out.println(node.val);
        }

        // go to left
        display(node.left, level + 1);
    }

    /// find Successor of a node
    public Node findSuccessor(int target) {
        return findSuccessor(root, target);
    }

    private Node findSuccessor(Node root, int target) {

        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == target) {
                break;
            }
        }

        return queue.peek();  // as found target return what is next in the queue => will be successor
    }

    public static void main(String[] args) {

        BST_Traversal bt = new BST_Traversal();

        int[] arr = {40, 20, 60, 10, 30, 50, 70, 9, 8};

        bt.populate(arr);

        bt.display();

        System.out.println();

        System.out.println("Traversal:------->");

        System.out.println("InOrder --->");
        bt.inOrder();
        System.out.println();

        System.out.println("\nPreOrder --->");
        bt.preOrder();
        System.out.println();

        System.out.println("\nPostOrder --->");
        bt.postOrder();
        System.out.println();
        System.out.println();

        // Searching
        boolean result = bt.search(80);
        System.out.println("found target?: " + result);

        int ans = bt.findMin();
        System.out.println("Minimum node-value in BST: " + ans);

        Node successorNode = bt.findSuccessor(60);

        if (successorNode != null) {
            System.out.println("Successor: " + successorNode.val);
        }

        else {
            System.out.println("No Successor");
        }
    }
}