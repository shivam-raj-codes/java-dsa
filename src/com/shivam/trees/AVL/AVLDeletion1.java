package com.shivam.trees.AVL;

public class AVLDeletion1 {

    // structure
    public class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value) {
            this.value = value;
            this.height = 0;
        }
    }
    public Node root; // root - node


    // insert
    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        else {
            node.right = insert(value, node.right);
        }

        // calculate height on insertion of newNode for each node from bottom -> up
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // is rotation required?
        return rotate(node);
    }

    // populate
    public void populate(int[] arr) {
        for (int  j : arr) {
            insert(j);
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // rotate - method
    public Node rotate(Node node) {
        int balanced = height(node.left) - height(node.right);


        if (balanced > 1) { // left - heavy
            if (height(node.left.left) - height(node.left.right) >= 0) {
                // LL - rotation
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // L - R => zigZag
                node.left = leftRotate(node.left); /// left rotate around child
                return rightRotate(node);
            }
        }

        if (balanced < -1) { // right - heavy
            if (height(node.right.left) - height(node.right.right) <= 0) {
                // RR - rotation
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                // R - L
                node.right = rightRotate(node.right); /// right rotate around child
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        // after rotation
        c.left = p;
        p.right = t;

        // update height;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c; // the new parent of rotated sub - Tree
    }

    public Node rightRotate(Node p) {
        // originally
        Node c = p.left;
        Node t = c.right;

        // rotate
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }


    // ---------------------- AVL - DELETION -------------------

    public void delete(int val) {
        if (root == null) {
            System.out.println("Tree Doesn't exist!");
            return;
        }
        root = delete(val, root);
    }
    public Node delete(int val, Node  node) {
        if (node == null) {
            return null;
        }

        // value found?
        if (val == node.value) {

            // case 1: have both child
            if (node.left != null && node.right != null ) {
                Node max = getMax(node.left); /// get max-value node from left

                node.value = max.value; /// replace node value with max

                node.left = delete(max.value, node.left);

                ///  as one node deleted it may affect balancing factor =>update height
               node.height = Math.max(height(node.left), height(node.right)) + 1;

               return rotate(node);
            }

            // case2: delete leaf node
            else if (node.left == null && node.right == null) {
                return null;
            }

            // case3: have one child
            else if (node.left != null) {
                return node.left;
            }
            else {
                return node.right;
            }

        }
        // Search & Delete them
        if (val < node.value) { // go left
            node.left = delete(val, node.left);
        }
        else { // go right
            node.right = delete(val, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node); //recursion should return updated Sub - Tree OR, if this node was not deleted return Self(Existing node)
    }

    // getMax
    public Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
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
            System.out.println("|----->" + node.value);
        }
        else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);
    }


    public static void main(String[] args) {
        AVLDeletion1 avlTree = new AVLDeletion1();
        int[] arr = {10, 20, 30,  50, 60};
        avlTree.populate(arr);
        avlTree.display();
    }
}
