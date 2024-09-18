package Strivers.BinaryTrees.Hard;
import java.util.*;
public class MinTimeToBurnTree {
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

    public static int minTime(Node root, int target) {
        // Map to track parent nodes
        Map<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        // Find the target node
        Node targetNode = getTheTargetNode(root, target);

        // Set to track visited nodes
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.add(targetNode);

        int seconds = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnedNewNodes = false;

            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Check parent
                if (parentMap.containsKey(current)) {
                    Node parent = parentMap.get(current);
                    if (!visited.contains(parent)) {
                        queue.offer(parent);
                        visited.add(parent);
                        burnedNewNodes = true;
                    }
                }

                // Check left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                    burnedNewNodes = true;
                }

                // Check right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                    burnedNewNodes = true;
                }
            }

            // If we burned new nodes this level, increment seconds
            if (burnedNewNodes) {
                seconds++;
            }
        }

        return seconds;
    }

    // Helper function to build the parent map
    private static void buildParentMap(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    // Helper function to find the target node by value
    private static Node getTheTargetNode(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;

        Node left = getTheTargetNode(root.left, target);
        if (left != null) return left;

        return getTheTargetNode(root.right, target);
    }
}
