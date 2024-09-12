package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;

public class SymmetricBinaryTree extends CodingNinjas {
    public static boolean isSymmetric(TreeNode root) {
        // Write your code here.
        if(root == null) return true;
        // the root will be same for the both of the tree, therefore check as two different tree
        // pass both of the side as separate tree
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode first, TreeNode second){
        if(first == null && second == null) return true; // return true if both of them are null
        if(first == null || second == null) return false; // return false, if one of them is not null
        if(first.data != second.data) return false; // return false if they are not equal
        return check(first.left, second.right) && check(first.right, second.left); // check for the left and right, and right and left
    }
}
