package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class KthSmallestElement extends Leetcode {
    private int ans = 0;
    private int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans; // return the answer
    }

    private void helper(TreeNode root, int k){
        if(root == null) return; // if root is null this means we have reach to end of this node

        helper(root.left, k); // go to the extreme left of the tree
        index++; // increase the index
        if(index == k){ // check if the index is equal to k or not
            ans = root.val; // if yes then save that answer and return
            return;
        }
        helper(root.right, k); // if not then call for right
    }
}
