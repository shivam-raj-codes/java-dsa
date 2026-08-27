package com.shivam.treepractice;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /// for current node find left subTree height & right subTree height
        int leftH = getLeftHeight(root);
        int rightH = getRightHeight(root);

        if (leftH == rightH) {
            /// it's a complete binary - Tree
            return (int)Math.pow(2, leftH) - 1;
        }

        else {
            /// go and find root's left & right subtree height
            return 1 + countNodes(root.left) + countNodes(root.right); // adding 1 for current node
        }
    }

    ///  left height
    static int getLeftHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

       int count = 1;

       while (node.left != null) {
           count++;
           node = node.left;
       }

       return count;
    }

    ///  right height
    static int getRightHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int count = 1;

        while (node.right != null) {
            count++;
            node = node.right;
        }

        return count;
    }


    /// bottom - up approach -> O(N longN)
//    static int helper(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        int left = helper(node.left);
//
//        int right = helper(node.right);
//
//        return left + right + 1;
//    }


    /// BFS
//    // Time -> O(N)
//    // Space -> O(N)
//    static int helper(TreeNode node) {
//        Queue<TreeNode> q = new LinkedList<>();
//
//        q.add(node);
//
//        int count = 0;
//        while (!q.isEmpty()) {
//            count++;
//            TreeNode nodeCur = q.poll();
//
//            if (nodeCur.left != null) {
//                q.add(nodeCur.left);
//            }
//            if (nodeCur.right != null) {
//                q.add(nodeCur.right);
//            }
//        }
//        return count;
//    }

}
