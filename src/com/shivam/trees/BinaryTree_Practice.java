package com.shivam.trees;

import java.util.Scanner;

public class BinaryTree_Practice {


    // Node - structure
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    private Node root;


    // insert element
    public void populate(Scanner sc) {
        System.out.println("Enter the root Node Value: ");
        int value = sc.nextInt();
        root = new Node(value);  // create root - node and assign value

        // fn call
        populate(sc, root); // passing -> Scanner object and root node
    }

    private void populate(Scanner sc, Node node) {
        // for left of root - node
        System.out.println("(true / false) ? Do you wanna insert element in LEFT of: " + node.value);

        boolean left = sc.nextBoolean(); // if user enter true

        // go to left and insert
        if (left) {

            System.out.println("Enter the value in LEFT of " + node.value);

            // taking input for value
            int value = sc.nextInt();

            // attaching new node as left child of current
            node.left = new Node(value);

            // if user want to insert further into left
            populate(sc, node.left); // recursively

        }

        System.out.println("(true / false) ? Do you wanna insert element in RIGHT of " + node.value);

        boolean right = sc.nextBoolean();

        // if user enter true
        if (right) {
            System.out.println("Enter the value in RIGHT of " + node.value);

            int value = sc.nextInt();

            // attaching new node as right child of current
            node.right = new Node(value);

            // recursive call
            populate(sc, node.right); // recursively call
        }


    }


    // display - fun
    public void display() {
        display(root, "Root node");
    }
    private void display(Node node, String message) {

        // base - case
        if (node == null) {
            return;
        }


        // at first call will print root - node
        System.out.println(message + " " + node.value);

        // go to left
        display(node.left, "Left of " + node.value + " : ");

        // go to right , when completely printed right
        display(node.right, "Right of " + node.value + " : ");
    }


    // pretty - Display
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level) {
        // base - case
        if (node == null) {
            return;
        }

        // go to right and as going increase level by 1
        prettyDisplay(node.right, level + 1);

        if (level != 0) { // means there are nodes in right - subTree
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t"); // indentation
            }
            // print value
            System.out.println("|------>" + node.value);
        }
        else { // no right - call means print the root node
            System.out.println(node.value);
        }

        // go to left also level increase by 1
        prettyDisplay(node.left, level + 1);
    }


    public static void main(String[] args) {
        BinaryTree_Practice tree = new BinaryTree_Practice();
        Scanner sc = new Scanner(System.in);

        // to invoke insert function
        tree.populate(sc);

        //display
        tree.display();

        tree.prettyDisplay();

    }
}