package Strivers.BinaryTrees.Easy;

import Strivers.BinaryTrees.CodingNinjas;

public class DiameterOfTree extends CodingNinjas {
    private int diameter = 0; // set diameter
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter; // return global variable
    }

    private int helper(TreeNode root){
        if(root == null) return 0; // return 0

        int left = helper(root.left); // get the height of left tree
        int right = helper(root.right); // get the height of right tree

        int di = left + right; // calculate the current diameter
        diameter = Math.max(di, diameter); // set the max diameter
        return 1 + Math.max(left, right); // return the height of the tree
    }
}
