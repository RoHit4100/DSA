package Strivers.BinaryTrees.Medium;

import java.util.ArrayList;

public class FindAllPathsOfBT {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        findPaths(root, ans, new ArrayList<>());
        return ans;
    }

    private static void findPaths(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
        if (root == null) return;

        // Add the current node to the list
        list.add(root.data);

        // If it's a leaf node, add the path to the answer
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list)); // Add a copy of the current path
        } else {
            // Recur for both left and right subtrees
            findPaths(root.left, ans, list);
            findPaths(root.right, ans, list);
        }

        // Backtrack by removing the current node from the list
        list.remove(list.size() - 1);
    }
}
