package Strivers.BinarySearchTree.Easy;

import Strivers.BinaryTrees.Hard.NodesAtDistanceK;

public class SearchInBST {
    // using binary search
    public TreeNode searchBSTOptimal(TreeNode root, int val) {
        if(root == null) return null; // return if root is null
        if(root.val == val) return root; // return the current node if it equals to the target value
        if(root.val < val) { // check if the current node's value is smaller than the target
            return searchBST(root.right, val);  // if yes the search on the right side of the tree
        }else{
            return searchBST(root.left, val); // if smaller, then search on the left side of the tree
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // using brute force
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val) return root;

        // perform the search using dfs
        return inOrder(root, val);
    }

    private TreeNode inOrder(TreeNode root, int target){
        if(root == null) return null;

        if(root.val == target) return root;

        TreeNode left = inOrder(root.left, target);
        if(left != null) return left;

        return inOrder(root.right, target);
    }

}
