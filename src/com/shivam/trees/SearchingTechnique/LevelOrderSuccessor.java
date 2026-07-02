package com.shivam.trees.SearchingTechnique;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode findSuccessor(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == target) {
                break;
            }
        }
        return queue.peek();  // as found target return what is next in the queue => will be successor
    }
}
