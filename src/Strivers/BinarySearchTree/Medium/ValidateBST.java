package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class ValidateBST extends Leetcode {
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true; // if root is leaf then return true

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);  // node value can have greater values than integer min and max that's why take long
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true; // if root is null, then return null, this means we didn't find any violation

        if(root.val <= min || root.val >= max){ // CHECK FOR THE VIOLATION, which will be a value is smaller than the min, and greater than the max
            return false;
        }
        // while going left, all the left values has to be smaller than the current nodes value
        return helper(root.left, min, root.val) && helper(root.right, root.val, max); // and while going in the right all the values has to greater than the node's value
    }
}
