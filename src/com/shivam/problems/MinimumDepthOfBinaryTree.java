package com.shivam.problems;

public class MinimumDepthOfBinaryTree {
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

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return helper(root, 1); // count -> starts with 1 as single node in tree itself a depth.
    }

    public static int helper(TreeNode node, int count) {

        if(node == null) {
            return count;
        }

        // Leaf node
        if(node.left == null && node.right == null) {
            return count;
        }

        // skewed - tree case
        if(node.left == null) {
            // only right side of root has nodes
            return helper(node.right, count + 1);
        }

        if(node.right == null) {
            // only left side of root has nodes
            return helper(node.left, count + 1);
        }

        int leftAns = helper(node.left, count + 1);

        int rightAns = helper(node.right, count + 1);

        return Math.min(leftAns, rightAns);
    }
}
