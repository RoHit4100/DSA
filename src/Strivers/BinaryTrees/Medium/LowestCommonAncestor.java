package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;

public class LowestCommonAncestor extends CodingNinjas {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        if(root == null) return null; // return null if root is null

        if(root == first || root == second) return root; // return the root if it matches with the given node
        TreeNode left = lowestCommonAncestor(root.left, first, second); // search on the left side
        TreeNode right = lowestCommonAncestor(root.right, first, second); // search on the right side

        if(left != null && right != null) return root; // return current node, if we found both of the nodes

        return left == null ? right: left; // if left is null, then return right, or else return left itself
    }
}
