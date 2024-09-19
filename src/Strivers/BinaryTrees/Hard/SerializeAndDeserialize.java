package Strivers.BinaryTrees.Hard;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class SerializeAndDeserialize  extends CodingNinjas {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // Handle the case when the root is null
            if (root == null) return "n ";

            // Use StringBuilder for efficient string concatenation
            StringBuilder ans = new StringBuilder();
            // Use a queue for level-order traversal (BFS)
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    // If the current node is null, append "n " to represent it
                    if (current == null) {
                        ans.append("n ");
                        continue;
                    }
                    // Append the value of the current node followed by a space
                    ans.append(current.data+ " ");
                    // Add left and right children to the queue for further processing
                    queue.offer(current.left);
                    queue.offer(current.right); // Fix: Add right child instead of duplicating left child
                }
            }
            return ans.toString(); // Return the serialized string
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // Check if the data is null or empty
            if (data == null || data.isEmpty()) return null;

            // Split the data string into parts based on spaces
            String[] arr = data.split(" ");
            // If the first element is "n", the tree is empty
            if (arr[0].equals("n")) return null;

            // Create the root node with the first value
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            // Use a queue to perform level-order traversal (BFS) for reconstruction
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1; // Start processing the elements from the second position
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();

                // Check if there is a left child
                if (i < arr.length && !arr[i].equals("n")) { // Fix: Use .equals() for string comparison
                    // Create the left child node and attach it to the current node
                    TreeNode leftNode = new TreeNode(Integer.parseInt(arr[i]));
                    current.left = leftNode;
                    queue.offer(leftNode); // Add left child to the queue
                }
                i++;

                // Check if there is a right child
                if (i < arr.length && !arr[i].equals("n")) {
                    // Create the right child node and attach it to the current node
                    TreeNode rightNode = new TreeNode(Integer.parseInt(arr[i]));
                    current.right = rightNode;
                    queue.offer(rightNode); // Add right child to the queue
                }
                i++;
            }

            return root; // Return the reconstructed tree
        }

    }
}
