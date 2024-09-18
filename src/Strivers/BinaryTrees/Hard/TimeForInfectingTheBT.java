package Strivers.BinaryTrees.Hard;
import java.util.*;
public class TimeForInfectingTheBT {
    private class TreeNode {
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
    class Solution {
        public int amountOfTime(TreeNode root, int start) {
            // first get the parents of each node
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            insertParents(root, parentMap);

            // now we have the parents, get the target node
            TreeNode target = getTheTargetNode(root, start);
            // now take the visited set
            Set<TreeNode> visited = new HashSet<>();
            // start the infection from the target node
            visited.add(target);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(target);
            int minutes = 0;

            // perform BFS
            while(!queue.isEmpty()){
                int size = queue.size();
                boolean infected = false;  // reset infection status for each level
                for(int i = 0; i < size; i++){
                    TreeNode current = queue.poll();

                    // check for the parent
                    if (parentMap.containsKey(current)) {
                        TreeNode parent = parentMap.get(current);
                        if(!visited.contains(parent)){
                            visited.add(parent);
                            queue.offer(parent);
                            infected = true;
                        }
                    }

                    // check for the left child
                    if(current.left != null && !visited.contains(current.left)){
                        visited.add(current.left);
                        queue.offer(current.left);
                        infected = true;
                    }

                    // check for the right child
                    if(current.right != null && !visited.contains(current.right)){
                        visited.add(current.right);
                        queue.offer(current.right);
                        infected = true;
                    }
                }

                // only increase the minutes, if any of the node is infected
                if (infected) minutes++;
            }

            return minutes;
        }

        private void insertParents(TreeNode root, Map<TreeNode, TreeNode> parentMap){
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
        }

        private TreeNode getTheTargetNode(TreeNode root, int target) {
            if (root == null) return null;
            if (root.val == target) return root;

            TreeNode left = getTheTargetNode(root.left, target);
            if (left != null) return left;

            return getTheTargetNode(root.right, target);
        }
    }

}
