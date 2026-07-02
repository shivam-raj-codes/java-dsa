package com.shivam.avltree;


public class AVLDeletion {
    // Node - Structure
    public static class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value) { // every newly Created Node will have there value and height
            this.value = value;
            this.height = 0;
        }
    }
    public Node root;

    // insertion
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

        node.height = Math.max(height(node.left), height(node.right)) + 1; /// bottom-up update all node height

        return rotate(node);
    }
    // populate
    public void populate(int[] arr) {
        for (int value : arr) {
            insert(value);
        }
    }


    // height - calculate
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // rotation if needed
    public Node rotate(Node node) {
        int balanced = height(node.left) - height(node.right);
//        int leftChildBF = height(node.left.left) - height(node.left.right);
//        int rightChildBF = height(node.right.left) - height(node.right.right);

        // rotation possible if balanced > 1 or balanced < -1

        if (balanced > 1) { /// left - heavy

            // which rotation to apply?
            if (height(node.left.left) - height(node.left.right) >= 0) { // => left's left is heavy
                // L -L
                return rightRotate(node); /// right rotate around parent
            }

            if (height(node.left.left) - height(node.left.right) < 0) { // => left's right is heavy
                // L - R => zigZg
                node.left = leftRotate(node.left); /// left rotate around child => can come in st. line
                return rightRotate(node); // rotate around Parent
            }
        }

        if (balanced < -1) { /// right - heavy

            // which rotation to apply?
            if (height(node.right.left) - height(node.right.right) > 0) { // => right's left is heavy
                // R - L => zigZag
                node.right = rightRotate(node.right); // to make in st. line
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) <= 0) { // => right's right is heavy
                return leftRotate(node); // rotate around Parent
            }
        }

        // no rotation needed => simply return the node without performing Any rotation
        return node;
    }

    // left rotation
    public Node leftRotate(Node p) {
        // originally
        Node c = p.right;
        Node t = c.left;

        // rotate
        c.left = p; // c become new parent of rotated subtree
        p.right = t;


        // update height
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c; // return new Parent - node of Sub - tree
    }

    // right - rotation
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


    // Deletion
    public void delete(int value) {
        if (root == null) {
            System.out.println("Tree Doesn't exist! Can't Delete Node.");
            return;
        }
        root = delete(value, root);
    }
    private Node delete(int target, Node node) {
        if (node == null) {
            return null;
        }


        // When Target found then all these Cases
        if (target == node.value) {

            // CASE 1: Node have both L & R child
            if (node.left != null && node.right != null) { // both right n left child exist
                Node max = getMax(node.left);

                node.value = max.value;  // replacing only the Node value.


                // ⚠️ To delete that max(Duplicate) Node from Left
                node.left = delete(max.value, node.left);


                /// before rotate update height
                node.height = Math.max(height(node.left), height(node.right)) + 1;
                return rotate(node);   // returning updated subtree
            }

            // Case 2: delete Leaf node
            else if (node.left == null && node.right == null) { // => leaf node
                return null;
            }


            // Case 3: have Only left child
            else if (node.left != null) {
                return node.left;     // returning that single child after deleting that node
            }

            // case 4: have Only right child
            else {
                return node.right;
            }
        }


        // Search & Delete them
        if (target < node.value) { // go left
            node.left = delete(target, node.left);
        }
        else { // go right
            node.right = delete(target, node.right);
        }


        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node); //recursion should return updated Sub - Tree OR, if this node was not deleted return Self(Existing node)
    }

    // getMax fun => get Max from left sub-tre
    public Node getMax (Node node) {
        if (node.right == null) {
            return node;
        }

        // go till extreme right
        return getMax(node.right);
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
            for (int i = 0; i < level - 1; i++) { // for indentation
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.value);
        } else {
            System.out.println(node.value);
        }

        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        AVLDeletion delete = new AVLDeletion();
        int[] arr = {50, 30, 70, 20, 40, 60, 80};
        delete.populate(arr);
        delete.display();
        System.out.println();
        delete.delete(50);
        delete.display();
    }
}
