package Strivers.BinaryTrees.Medium;

import java.util.*;

public class TopView {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    // Class to store the node value and its level in the tree
    static class Pair {
        int data;   // Node value
        int level;  // Vertical level of the node
        Pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    class Solution {
        static class Pair{
            Node node;
            int col;
            Pair(Node node, int col){
                this.node = node;
                this.col = col;
            }
        }
        // with bfs
        static ArrayList<Integer> topViewBFS(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans; // return empty list if root is null

            Map<Integer, Integer> map = new TreeMap<>(); // create map which will store current col and the value associated with it
            Queue<Pair> queue = new LinkedList<>(); // create queue which will store the current col and node associated with it
            queue.offer(new Pair(root, 0)); // insert root and 0 as initial col

            // perform bfs
            while (!queue.isEmpty()) {
                int size = queue.size();  // get the size

                for (int i = 0; i < size; i++) { // remove all element present in the queue, and add their childrens, if they exist
                    Pair currentPair = queue.poll(); // get the first pair
                    assert currentPair != null;
                    Node current = currentPair.node; // get the current node from the pair
                    int col = currentPair.col; // get the current col from the pair
                    if (!map.containsKey(col)) { // check if this col is first time encountered
                        map.put(col, current.data); // if yes then insert the current col and current node into the map
                    }

                    if(current.left != null) queue.offer(new Pair(current.left, col - 1)); // check if left exist or not
                    if(current.right != null) queue.offer(new Pair(current.right, col + 1)); // check if right exist or not
                }
            }

            // add all the answers into ans
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){ // insert all the answers into the ans from map
                ans.add(entry.getValue());// tree map will store the values in sorted format according to the keys
            }

            return ans;
        }

    }






    // Function to return the top view of the binary tree, with dfs
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;  // If the tree is empty, return an empty list

        // TreeMap to store the first encountered node at each horizontal distance (column)
        // Key: horizontal distance (column), Value: Pair (node data, vertical level)
        Map<Integer, Pair> map = new TreeMap<>();

        // Pre-order traversal to fill the map with topmost nodes for each column
        preOrder(root, 0, 0, map);

        // Add the values from the map (topmost node for each column) to the result list
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }
        return ans;
    }

    // Helper function for pre-order traversal of the tree
    // Parameters:
    // root: current node
    // col: horizontal distance (column) from the root
    // level: vertical level of the node
    // map: stores the topmost node for each column
    private static void preOrder(Node root, int col, int level, Map<Integer, Pair> map) {
        if (root == null) return;  // Base case: return if node is null

        // Check if the current column is encountered for the first time or if the node is higher
        if (!map.containsKey(col) || map.get(col).level > level) {
            map.put(col, new Pair(root.data, level));  // Update the map with the topmost node for this column
        }

        // Recursively traverse the left and right subtrees
        preOrder(root.left, col - 1, level + 1, map);  // Traverse the left subtree (col decreases)
        preOrder(root.right, col + 1, level + 1, map); // Traverse the right subtree (col increases)
    }

    /*
         10         <- root (level 0, col 0)
        /  \
       5    15      <- level 1, col -1 (5) and col 1 (15)
      / \     \
     3   7     20   <- level 2, col -2 (3), col 0 (7), and col 2 (20)
          \
           9        <- level 3, col 1
     */

}
