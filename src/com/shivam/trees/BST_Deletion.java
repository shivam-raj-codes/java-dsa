package com.shivam.trees;

public class BST_Deletion {
    private Node root;


    public class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    // insertion
    public void insert(int value) {
       root = insert(value, root);
    }
    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.val) {
            // go to left
            node.left = insert(val, node.left);
        }
        else {
            // go to right
            node.right = insert(val, node.right); // found null in right => insert there and return that inserted node reference to node.right
        }

        return node; // when nothing new been inserted return the existing node
    }

    // to populate
    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]); // calling insert fn
        }
    }


    // ----------------------- DELETION -----------------------


    public void delete(int value) {
        if (root == null) {
            System.out.println("Tree Doesn't exist! Can't Delete Node.");
            return;
        }
        root = delete(value, root);
    }
    private Node delete(int target, Node node) {
        if (node == null) {
            System.out.println("Not found Target Node");
            return null;
        }


        // When Target found then all these Cases
        if (target == node.val) {

            // CASE 1: Node have both L & R child
            if (node.left != null && node.right != null) { // both right n left child exist
                Node max = getMax(node.left);

                node.val = max.val;  // replacing only the Node value.


                // ⚠️ To delete that max(Duplicate) Node from Left
                node.left = delete(max.val, node.left);

                return node;   // returning updated subtree
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
        if (target < node.val) { // go left
            node.left = delete(target, node.left);
        }
        else { // go right
            node.right = delete(target, node.right);
        }



        return node; //recursion should return updated Sub - Tree OR, if this node was not deleted return Self(Existing node)
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
        // go to right
        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");     // indentation
            }
            System.out.println("|------->" + node.val); // value print after indentation
        } else {
            System.out.println(node.val); // for root - print
        }

        // for left
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        BST_Deletion bt = new BST_Deletion ();

        int[] arr = {17, 15, 16, 19, 18, 13, 21, 10, 23};
        bt.populate(arr);
        bt.display();
        System.out.println("\n");

        // ----------------------- DELETION -----------------------
        System.out.println("Delete Node of Value: 17");
        bt.delete( 17);
        bt.display();

        System.out.println("\nDelete Node of Value: 15");
        bt.delete(15);
        bt.display();
    }
}
