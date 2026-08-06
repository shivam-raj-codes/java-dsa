package com.shivam.treepractice;

public class SumOfLeftLeaves {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }


    static int helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left, true); /// go to left

        int sum = 0;
        if (node.left == null && node.right == null && isLeft) {
            /// left leaf I'm left child of my parent
            sum += node.val;
        }

        int right = helper(node.right, false); /// go to right

        return sum + left + right;
    }
}
