package com.shivam.trees.SearchingTechnique;

public class isCousins {
//    class Solution {
//        public boolean isCousins(TreeNode root, int x, int y) {
//
//            Queue<TreeNode> q = new LinkedList<>();
//            q.offer(root);
//
//            while (!q.isEmpty()) {
//
//                int size = q.size();
//
//                boolean foundX = false;
//                boolean foundY = false;
//
//                for (int i = 0; i < size; i++) {
//
//                    TreeNode node = q.poll();
//
//                    if (node.val == x) {
//                        foundX = true;
//                    }
//
//                    if (node.val == y) {
//                        foundY = true;
//                    }
//
//                    // Check if they are siblings
//                    if (node.left != null && node.right != null) {
//
//                        int left = node.left.val;
//                        int right = node.right.val;
//
//                        if ((left == x && right == y) ||
//                                (left == y && right == x)) {
//                            return false;
//                        }
//                    }
//
//                    if (node.left != null) {
//                        q.offer(node.left);
//                    }
//
//                    if (node.right != null) {
//                        q.offer(node.right);
//                    }
//                }
//
//                // After processing one level
//
//                if (foundX && foundY) {
//                    return true;
//                }
//
//                if (foundX || foundY) {
//                    return false;
//                }
//            }
//
//            return false;
//        }
//    }
}
