package Strivers.BinarySearchTree.Hard;

import Strivers.SldingWindowAndTwoPointer.Medium.FruitsIntoBasket;

import java.util.LinkedList;
import java.util.Queue;

public class LargestBSTInBT {
    // this will be the optimal solution
    static class NodeValue {
        int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    static int largestBstOptimal(Node root) {
        // Start the helper function and return the size of the largest BST
        return helper(root).maxSize;
    }

    static NodeValue helper(Node root) {
        // Base case: an empty tree is a BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from the left and right subtrees
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // If the current node makes a valid BST with its left and right subtrees
        if (left.maxNode < root.data && root.data < right.minNode) {
            // Return updated values for the current node as a valid BST
            return new NodeValue(
                    Math.min(root.data, left.minNode),  // The minimum value in the subtree
                    Math.max(root.data, right.maxNode), // The maximum value in the subtree
                    left.maxSize + right.maxSize + 1    // The size of the subtree
            );
        }

        // If it's not a valid BST, return the maximum size of the left or right subtree
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

     class Node {
         int data;
         Node left, right;

         public Node(int d) {
             data = d;
             left = right = null;
         }
     }


     // brute force solution, which will use the validate bst function to validate the tree is bst or not
     static int largestBst(Node root) {
         // Write your code here
         if (root.left == null && root.right == null) return 1;

         Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         int maxSize = 1;

         while (!queue.isEmpty()) {
             int size = queue.size();

             for (int i = 0; i < size; i++) {
                 Node current = queue.poll();

                 // Check if the current subtree rooted at `current` is a valid BST
                 if (validateBST(current, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                     int s = size(current);
                     maxSize = Math.max(s, maxSize);
                 }

                 // Offer the left and right children to the queue for further processing
                 if (current.left != null) queue.offer(current.left);
                 if (current.right != null) queue.offer(current.right);
             }
         }
         return maxSize;
     }

    // Function to find the size of the tree
    private static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right); // Correct size calculation
    }

    // Function to validate if the given tree is a BST
    private static boolean validateBST(Node root, int min, int max) {
        if (root == null) return true;

        // Check if the current node violates the BST property
        if (root.data <= min || root.data >= max) return false;

        // Recursively check the left and right subtrees
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
}
