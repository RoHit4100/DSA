package Strivers.BinaryTrees.Medium;

import java.util.*;
public class CountTheNoOfNodesInCompleteBT {
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

    public int countNodesOptimal(TreeNode root) {
        // using property of the complete binary tree, which has the same height
        if(root == null) return 0;

        // first check if the height of the both left and right side is same
        int leftHeight = leftHeight(root); // get the height of the left side
        int rightHeight = rightHeight(root); // get the height of the right side of the tree
        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1; // if both of the heights are equal then apply the formula form complete binary tree,
            // which is 2 ^ height - 1
        }
        // if height is not equal then do the same for left tree and right tree
        return countNodesOptimal(root.left) + countNodesOptimal(root.right) + 1;
    }

    private int leftHeight(TreeNode node){
        int height = 0;
        while(node != null){
            node = node.left;
            height++;
        }

        return height;
    }

    private int rightHeight(TreeNode node){
        int height = 0;
        while(node != null){
            node = node.right;
            height++;
        }

        return height;
    }

    public int countNodes(TreeNode root) {
        // brute force solution will be counting the nodes in the binary tree
        if(root == null) return 0;
        // use the bfs to count the nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null) {
                    count++;
                    queue.offer(current.left);
                }
                if(current.right != null){
                    count++;
                    queue.offer(current.right);
                }
            }
        }
        return count;
    }
}
