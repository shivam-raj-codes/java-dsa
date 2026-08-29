package com.shivam.treepractice;

public class pathSumI {
    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    private boolean helper(TreeNode node, int remaining) {
        if (node == null) {
            return false;
        }

        remaining -= node.val;

        // reached leaf
        if (node.left == null && node.right == null) {
            return remaining == 0;
        }

        return helper(node.left, remaining) || helper(node.right, remaining);
    }
}
