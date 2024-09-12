package Strivers.BinaryTrees.Hard;

import java.util.ArrayList;

public class BoundaryTraversal {
     class Node {
        int data;
        Node left, right;

        public Node(int d){
         data = d;
         left = right = null;
        }
     }

    // using recursion
    public class Solution {
        private static boolean isLeaf(Node node) {
            return node.left == null && node.right == null;
        }

        public ArrayList<Integer> boundary(Node node) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (node == null) return ans;

            // Add root node if it's not a leaf
            if (!isLeaf(node)) ans.add(node.data);

            // Add the left boundary (excluding leaf nodes)
            addLeftBoundary(node.left, ans);

            // Add all leaf nodes (from both left and right subtrees)
            addLeafNodes(node, ans);

            // Add the right boundary (excluding leaf nodes, in reverse order)
            addRightBoundary(node.right, ans);

            return ans;
        }

        // Recursively add the left boundary nodes
        private static void addLeftBoundary(Node node, ArrayList<Integer> list) {
            if (node == null || isLeaf(node)) return;

            list.add(node.data);  // Add the node

            // Prioritize left subtree, if it exists; otherwise, go to right subtree
            if (node.left != null) {
                addLeftBoundary(node.left, list);
            } else {
                addLeftBoundary(node.right, list);
            }
        }

        // Recursively add all leaf nodes
        private static void addLeafNodes(Node node, ArrayList<Integer> list) {
            if (node == null) return;

            // If it's a leaf node, add it to the list
            if (isLeaf(node)) {
                list.add(node.data);
            } else {
                // Otherwise, traverse both subtrees
                if (node.left != null) addLeafNodes(node.left, list);
                if (node.right != null) addLeafNodes(node.right, list);
            }
        }

        // Recursively add the right boundary nodes (in reverse order)
        private static void addRightBoundary(Node node, ArrayList<Integer> list) {
            if (node == null || isLeaf(node)) return;

            // Prioritize right subtree, if it exists; otherwise, go to left subtree
            if (node.right != null) {
                addRightBoundary(node.right, list);
            } else {
                addRightBoundary(node.left, list);
            }

            // Add after recursive call to ensure reverse order
            list.add(node.data);
        }
    }
}
