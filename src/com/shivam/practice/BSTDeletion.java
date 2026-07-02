package com.shivam.practice;

public class BSTDeletion {

    // structure
    public static class Node {
        Node left;
        Node right;
        int val;

        public Node(int value) {
            this.val = value;
        }
    }

    // root - node As Global
    private Node root;


    // insert
    public void insert(int value) {
        root = insert(value, root);
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

    // to populate
    public void populate(int[] arr) {
        for (int i : arr) {
            insert(i);
        }
    }

    // deletion
    public void delete(int target) {
        if (root == null) {
            System.out.println("Tree not Exist!");
            return;
        }
        delete(target, root);
    }
    public Node delete(int target, Node node) {
        if (node == null) {
            System.out.println("Node not found!");
            return null;
        }

        if (node.val == target) {

            // case 1: have two child
            if (node.left != null && node.right != null) {
                Node max = getMax(node.left);

                node.val = max.val; // deleted node with both child

                node.left = delete(max.val, node.left); // deleting that duplicate node

                return node;
            }

            // case 2: Leaf - Node delete
            else if (node.left == null && node.right == null) {
                return null;
            }

            // case 3: Node with one child
            else if (node.left != null) {
                // remove left child
                return node.left;
            }
            else {
                // remove right child
                return node.right;
            }
        }

        if (target < node.val) {
            node.left = delete(target, node.left);
        } else {
            node.right = delete(target, node.right);
        }

        return node; //recursion should return updated Sub - Tree OR, if this node was not deleted return Self(Existing node)
    }

    // getMAx fun
    public Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }

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
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        }
        else {
            System.out.println(node.val);
        }

        // go left
        display(node.left, level + 1);
    }


    // main
    public static void main(String[] args) {
        BSTDeletion bt = new BSTDeletion();
        int[] arr = {15, 8, 10, 17, 16, 4, 18};
        bt.populate(arr);
        bt.display();
        bt.delete(15);
        System.out.println("Deleting Node with Value -> 8 ");
        bt.display();
    }
}
