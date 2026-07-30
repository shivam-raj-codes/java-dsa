package com.shivam.treepractice;


public class SumRootToLeafNumber {
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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    static int helper(TreeNode node, int currSum) {
        if (node == null) {
            return 0;
        }

        int sum = currSum * 10 + node.val;

        int left = helper(node.left, sum); // go to left and build sum till leaf
        int right = helper(node.right, sum); // go to right & build sum till leaf

        /// at leaf
        if (node.left == null && node.right == null) {
            return sum;
        }

        return left + right;
    }
}
