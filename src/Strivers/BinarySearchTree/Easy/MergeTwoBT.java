package Strivers.BinarySearchTree.Easy;

import Strivers.BinarySearchTree.Leetcode;

public class MergeTwoBT extends Leetcode {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null; // if both of them are null then return null

        if(root1 == null) return root2; // if root1 is null then return root2
        if(root2 == null) return root1; // if root2 is null then return root1

        // if we are at this lines means both of them are not null
        // so add the both of the nodes and create new node
        TreeNode root = new TreeNode(root1.val + root2.val);
        // left will be the left calls
        root.left = mergeTrees(root1.left, root2.left);
        // right will be the right calls
        root.right = mergeTrees(root1.right, root2.right);
        // in the end return the root
        return root;
    }
}
