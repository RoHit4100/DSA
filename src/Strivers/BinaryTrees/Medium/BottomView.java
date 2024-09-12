package Strivers.BinaryTrees.Medium;
import java.util.*;
public class BottomView {
    // using bfs
    public class Solution {

        // Pair class to hold TreeNode and its corresponding column index.
        public static class Pair {
            TreeNode node;
            int col;

            Pair(TreeNode node, int col) {
                this.node = node;
                this.col = col;
            }
        }

        // Function to return the bottom view of a binary tree.
        public static List<Integer> bottomView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null) return ans;

            // TreeMap to store the bottom-most node for each column.
            TreeMap<Integer, Integer> map = new TreeMap<>();

            // Queue for level-order traversal, storing pairs of node and column index.
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 0));

            // Perform level-order traversal (BFS).
            while (!queue.isEmpty()) {
                // Get the front pair from the queue.
                Pair pair = queue.poll();
                TreeNode current = pair.node;
                int col = pair.col;

                // Update the map with the current node's value for this column.
                // As we traverse level by level, this will overwrite nodes that are higher.
                map.put(col, current.data);

                // Add the left and right children with updated column indices.
                if (current.left != null) queue.offer(new Pair(current.left, col - 1));
                if (current.right != null) queue.offer(new Pair(current.right, col + 1));
            }

            // Add all the bottom view nodes (sorted by column index) to the result.
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }

            return ans;
        }
    }

    // Definition for the TreeNode class.
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }


    class Node{
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references

        // Constructor of tree node
        public Node(int key)
        {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // TreeMap to store the bottommost node for each horizontal distance (column).
        // Key: horizontal distance (column), Value: Pair (node data, vertical level)
        Map<Integer, Pair> map = new TreeMap<>();

        // Start the pre-order traversal with the root, column 0, and level 0.
        preOrder(root, 0, 0, map);

        // Add the bottommost nodes from the map to the result list.
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }
        return ans;
    }

    // Helper class to store the node value and its level.
    static class Pair {
        int data;
        int level;
        Pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    // Modified pre-order traversal to find the bottom view.
    private void preOrder(Node root, int col, int level, Map<Integer, Pair> map) {
        if (root == null) return;

        // Update the map if the column is not yet encountered or if the current node
        // is at a deeper level than the existing node in the same column.
        if (!map.containsKey(col) || map.get(col).level <= level) {
            map.put(col, new Pair(root.data, level));
        }

        // Recursively traverse the left and right subtrees with updated column and level.
        preOrder(root.left, col - 1, level + 1, map);
        preOrder(root.right, col + 1, level + 1, map);
    }
}
