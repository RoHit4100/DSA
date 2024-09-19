package Strivers.BinaryTrees.Medium;
import java.util.*;
public class CompletenessOfBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        // Create a queue to perform level-order traversal (breadth-first search)
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.offer(root);

        // Boolean variable to track if a null node has been encountered
        boolean isPreviousNull = false;

        // Continue the level-order traversal until the queue is empty
        while (!queue.isEmpty()) {
            // Dequeue the current node from the queue
            TreeNode current = queue.poll();

            // If the current node is null, mark that a null node has been encountered
            if (current == null) {
                isPreviousNull = true;
            } else {
                // If a null node was previously encountered and now we see a non-null node,
                // the tree is not complete, so return false
                if (isPreviousNull) return false;

                // Add the left and right children of the current node to the queue
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // If no non-null node appeared after a null node, the tree is complete, so return true
        return true;
    }

}
