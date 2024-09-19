package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class DeleteNodeInBST extends Leetcode {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the root is null, return null (empty tree).
        if (root == null) return null;

        // If the node to be deleted is the root node, call the helper to delete it.
        if (root.val == key) {
            return helper(root);
        }

        TreeNode current = root; // Initialize the current node to the root.

        // Loop to traverse the tree and find the node with the key.
        while (current != null) {
            if (current.val < key) {
                // If the key is greater than the current node's value, go right.
                if (current.right != null && current.right.val == key) {
                    // If the right child matches the key, delete it using the helper function.
                    current.right = helper(current.right);
                    break; // Exit the loop after deleting.
                } else {
                    current = current.right; // Move to the right child.
                }
            } else {
                // If the key is less than the current node's value, go left.
                if (current.left != null && current.left.val == key) {
                    // If the left child matches the key, delete it using the helper function.
                    current.left = helper(current.left);
                    break; // Exit the loop after deleting.
                } else {
                    current = current.left; // Move to the left child.
                }
            }
        }
        return root; // Return the root after the deletion is completed.
    }

    private TreeNode helper(TreeNode target) {
        // If the target node has no left child, return its right child (deleting it).
        if (target.left == null) return target.right;

        // If the target node has no right child, return its left child (deleting it).
        if (target.right == null) return target.left;

        // If the target has both left and right children:
        TreeNode rightChild = target.right; // Store the right child.

        // Find the rightmost node of the left subtree (largest in left subtree).
        TreeNode lastRight = lastRight(target.left);

        // Attach the original right child to the rightmost node of the left subtree.
        lastRight.right = rightChild;

        // Return the left child as the new root of this subtree.
        return target.left;
    }

    private TreeNode lastRight(TreeNode node) {
        // Recursively find the rightmost node in the subtree.
        if (node.right == null) return node;
        return lastRight(node.right);
    }

}
