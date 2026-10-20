package com.shivam.problems;

public class SubtreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return search(root, subRoot);
    }

    //  search through BIG tree
    public boolean search(TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }

        if (node.val == target.val) {
            if (isSameTree(node, target)) {
                return true;
            }
        }


        // searching for subTree - root in SuperTree either in Left or Right
        return search(node.left, target) || search(node.right, target);
    }

    public boolean isSameTree(TreeNode treeRoot, TreeNode subRoot) {
        if (treeRoot == null || subRoot == null) {
            return treeRoot == subRoot;
        }

//        if (treeRoot == null && subRoot != null) {
//            return false;
//        } else if (treeRoot != null && subRoot == null) {
//            return false;
//        }
          if (treeRoot.val != subRoot.val) {
              return false;
          }

        return isSameTree(treeRoot.left, subRoot.left) && isSameTree(treeRoot.right, subRoot.right);
    }
}
