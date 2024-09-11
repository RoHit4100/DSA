package Strivers.BinaryTrees.Easy;

import Strivers.BinaryTrees.CodingNinjas;

public class TreeIsBalancedOrNot extends CodingNinjas {
    public  boolean isBalancedBT(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;  // If height returns -1, the tree is not balanced
    }

    private int heightOptimal(TreeNode root) {
        if (root == null) return 0;  // Base case: height of null node is 0

        int left = height(root.left);
        int right = height(root.right);

        // If the subtree is unbalanced, propagate the -1 upwards
        if (left == -1 || right == -1) return -1;

        // If the height difference of the left and right subtree is more than 1, return -1
        if (Math.abs(left - right) > 1) return -1;

        // Otherwise, return the height of the current node
        return 1 + Math.max(left, right);
    }



    // brute force solution
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; // return true if root is null

        int left = height(root.left); // get the height of the left tree
        int right = height(root.right); // get the height of the right tree
        if(Math.abs(left - right) > 1){  // check if the difference between both of the heights is greater than 1
            return false; // if yes then return false
        }

        boolean l = isBalanced(root.left); // if not then search for left tree
        boolean r = isBalanced(root.right); // if not then search for right tree
        return l && r; // return false, if any of the side returns false
    }


    private int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}
