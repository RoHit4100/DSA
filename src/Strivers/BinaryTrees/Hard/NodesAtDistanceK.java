package Strivers.BinaryTrees.Hard;
import java.util.*;
public class NodesAtDistanceK {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map to track parent nodes
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // BFS to populate the parentMap
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        // List to store the result
        List<Integer> ans = new ArrayList<>();
        // Set to track visited nodes
        Set<TreeNode> visited = new HashSet<>();
        // BFS to find nodes at distance k
        queue.offer(target);
        visited.add(target);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {
                // All nodes in the current level are at distance k
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ans.add(node.val);
                }
                return ans;
            }

            // Process nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // Add unvisited left child
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                // Add unvisited right child
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }
                // Add unvisited parent node
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    visited.add(parentMap.get(current));
                    queue.offer(parentMap.get(current));
                }
            }
            currentDistance++;
        }

        return ans;
    }
}
