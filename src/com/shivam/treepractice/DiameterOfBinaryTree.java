package com.shivam.treepractice;

public class DiameterOfBinaryTree {
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

    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight;
        diameter = Math.max(dia, diameter);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
