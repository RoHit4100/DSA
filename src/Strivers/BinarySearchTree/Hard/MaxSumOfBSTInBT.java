package Strivers.BinarySearchTree.Hard;

import Strivers.BinarySearchTree.Leetcode;
import java.util.*;

public class MaxSumOfBSTInBT extends Leetcode {
    // optimal solution
    public class Solution {
        // Class to hold the information of each subtree
        static class NodeValue {
            int minNode, maxNode, sum; // Minimum value, Maximum value, Sum of the subtree
            boolean isBST; // Whether the subtree is a BST

            NodeValue(int minNode, int maxNode, int sum, boolean isBST) {
                this.minNode = minNode;
                this.maxNode = maxNode;
                this.sum = sum;
                this.isBST = isBST;
            }
        }

        private int maxSum = 0; // Global variable to store the maximum sum

        public int maxSumBST(TreeNode root) {
            // Start the helper function and return the maximum sum of BSTs
            helper(root);
            return maxSum;
        }

        private NodeValue helper(TreeNode node) {
            if (node == null) {
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
            }

            // Get values from the left and right subtrees
            NodeValue left = helper(node.left);
            NodeValue right = helper(node.right);

            // Check if the current node forms a valid BST with its subtrees
            if (left.isBST && right.isBST && node.val > left.maxNode && node.val < right.minNode) {
                int sum = node.val + left.sum + right.sum;
                maxSum = Math.max(maxSum, sum);
                return new NodeValue(
                        Math.min(node.val, left.minNode),  // The minimum value in the subtree
                        Math.max(node.val, right.maxNode), // The maximum value in the subtree
                        sum,                               // The sum of the subtree
                        true                               // This subtree is a BST
                );
            }

            // If it's not a valid BST, return invalid results
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        }
    }

    // brute force solution
    public int maxSumBST(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;

        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(validateBST(current, Integer.MIN_VALUE, Integer.MAX_VALUE)){
                    int sum = sum(current);
                    maxSum = Math.max(sum, maxSum);
                }

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }
        return Math.max(0, maxSum);
    }

    private int sum(TreeNode root){
        if(root == null) return 0;

        return root.val + sum(root.left) + sum(root.right);
    }

    private boolean validateBST(TreeNode root, int min, int max){
        if(root == null) return true;

        // check for violation
        if(root.val <= min || root.val >= max){
            return false;
        }

        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }
}
