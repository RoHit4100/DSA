package Kunal.Hash.Questions;

import Kunal.Trees.BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal extends BFS {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();

        if (root == null) {
            return outer;
        }

        // Create a TreeMap to store nodes by their horizontal distance and their row level
        Map<Integer, List<int[]>> map = new TreeMap<>();

        // Call the helper function to fill the map
        helper(root, 0, 0, map);

        // Add all the lists from the map to the outer list
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            // Retrieve and sort the list based on row first and then value
            List<int[]> nodeList = entry.getValue();
            nodeList.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            // Extract sorted values from nodeList
            List<Integer> sortedValues = new ArrayList<>();
            for (int[] node : nodeList) {
                sortedValues.add(node[1]);
            }
            outer.add(sortedValues);
        }

        return outer;
    }

    private void helper(TreeNode node, int key, int row, Map<Integer, List<int[]>> map) {
        if (node == null) {
            return;
        }

        // Retrieve the list at this horizontal distance or create a new one
        List<int[]> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new int[]{row, node.val});
        map.put(key, list);

        // Recur for the left and right children with updated keys and rows
        helper(node.left, key - 1, row + 1, map);
        helper(node.right, key + 1, row + 1, map);
    }
}
