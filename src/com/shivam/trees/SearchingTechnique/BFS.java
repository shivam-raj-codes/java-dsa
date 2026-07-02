package com.shivam.trees.SearchingTechnique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); /// first root goes into queue

        while (!queue.isEmpty()) {

            System.out.println("Queue Size = " + queue.size());
            int levelSize = queue.size(); /// Tells -> How many nodes belong to the current level?

            /// every level will have current level list
            List<Integer> currentLevelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); /// removing currentNode from queue
                currentLevelList.add(currentNode.val); /// adding into Level list

                /// Adding children
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelList);
        }
        return result;
    }
}
