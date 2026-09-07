package com.shivam.problems;

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //static int maxDepth = 0;
//    static int helper(TreeNode node, int count) {
//        if (node == null) {
//            return 0;
//        }
//
//        if (node.left == null && node.right == null) {
//            maxDepth = Math.max(maxDepth, count);
//        }
//
//        helper(node.left, count++);
//
//        helper(node.right, count++);
//
//        return maxDepth;
//    }
}