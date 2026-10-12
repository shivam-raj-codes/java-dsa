package com.shivam.problems;

public class InvertBinaryTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        // storing left & right child of node.
        TreeNode left = invertTree(root.left);

        TreeNode right = invertTree(root.right);

        // swap left and right child of node
        root.left = right;

        root.right = left;

        return root;
    }
}
