package com.shivam.avltree;

public class AVL {

    // structure of Node
    public static class Node {
        Node left;
        Node right;
        int val;
        int height;

        public Node (int value) {
            this.val = value;
            this.height = 0;
        }
    }
    public Node root;

    // height - method
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // insertion
    public void insert (int val) {
        root = insert(val, root);
    }
    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val< node.val) {
            node.left = insert(val, node.left);
        }

        if (val > node.val) {
            node.right = insert(val, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1; // stores height of each new inserted node.

        return rotate(node); // before returning check is rotation required
    }

    // populate
    public void populate(int[] arr) {
        for (int i : arr) {
            insert(i);
        }
    }



    private Node rotate (Node node) {
        int balance = height(node.left) - height(node.right); // Balancing factor

        if (balance > 1) {    // left heavy

            if (height(node.left.left) - height(node.left.right) > 0) {
                // L - L case
                return rightRotate(node); // rotate around Parent
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // L -R case => zig - zag
                node.left = leftRotate(node.left); // left rotate around child to make it straight

                return rightRotate(node); // rotate around Parent
            }
        }

        if (balance < -1) { // right heavy

            if (height(node.right.left) - height(node.right.right) < 0) {
                // right - right case
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                 // R - L case = > Zig - Zag
                node.right = rightRotate(node.right); // make straight
                return leftRotate(node);
            }
        }

        // not required any rotation . if rotation happen then the node return after the rotation apply will be returned
        return node;
    }

    private Node leftRotate(Node p) {
        // originally
        Node c = p.right;
        Node t = c.left;

        // left rotate => becomes
        c.left = p;
        p.right = t;

        // update height
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        // return new root-node of rotated part
        return c;
    }


    private Node rightRotate(Node p) {
        // originally
        Node c = p.left;
        Node t = c.right;

        // right rotate => become
        c.right = p;
        p.left = t;

        // update height
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        // return new root-node of rotated part
        return c;
    }

    // display
    public void display() {
        if (root == null) {
            return;
        }
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
            System.out.println("|----->" + node.val);
        }
        else {
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] arr = {10, 20, 30,  50, 60};
        tree.populate(arr);
        tree.display();
    }
}
