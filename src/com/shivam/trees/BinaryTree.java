package com.shivam.trees;
import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    // root - Node of Binary Tree
    private Node root;

    // insert Elements: --
    public void populate(Scanner scanner) {
        // root - node & there values
        System.out.println("Enter the root NOde: ");
        int value = scanner.nextInt();
        root = new Node(value); // root node - created with there value
        populate(scanner, root); // function call Not recursively
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do You Wanna Enter the Left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) { // if true
            // for Left - Node
            System.out.println("Enter the value of left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value); // left node - created with their value
            populate(scanner, node.left); // recursively run till want to insert in left
        }

        // when if - block not execute
        // for Right - Node
        System.out.println("Do You want to enter the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right); // recursively run till want to insert in right
        }
    }


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


    public void display() {
        display(this.root, "Root node");
    }
    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
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
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        //tree.display();
        tree.prettyDisplay();

        System.out.println("\n" + tree.countNode() + "\n");
    }

}
