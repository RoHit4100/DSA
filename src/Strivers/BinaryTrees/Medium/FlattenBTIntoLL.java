package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;

public class FlattenBTIntoLL extends CodingNinjas {
    public void flatten(TreeNode root) {
        if (root == null) return; // If the root is null, there's nothing to flatten

        TreeNode node = root;
        while (node != null) {
            // Traverse the left subtree to find the rightmost node
            TreeNode left = node.left;
            while (left != null && left.right != null) {
                left = left.right; // Move to the rightmost node of the left subtree
            }

            // If a left subtree exists, attach it to the right subtree
            if (left != null) {
                left.right = node.right; // Connect the rightmost node of the left subtree to the right subtree
                node.right = node.left; // Attach the left subtree to the right
                node.left = null; // Set the left pointer to null
            }
            // Move to the next node in the flattened tree
            node = node.right;
        }
    }
}
