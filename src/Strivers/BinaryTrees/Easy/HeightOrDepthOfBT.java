package Strivers.BinaryTrees.Easy;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class HeightOrDepthOfBT extends CodingNinjas {
    // using Striver's method
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; // return 0 if root is null

        int left = maxDepth(root.left); // get the height of the left tree
        int right = maxDepth(root.right); // get the height of the right tree

        return 1 + Math.max(left, right); // height of the current tree will be 1 + max(left and right).
    }


    // using dfs
    public static int heightOfBinaryTreeDFS(TreeNode root) {
        // Write your code here.
        if(root == null) return 0; // if root is null then return 0;
        return helper(root, 0); // return the height of BT
    }

    private static int helper(TreeNode root, int length){
        if(root == null) return length; // if we found the end then return the length till that point

        int left = helper(root.left, length + 1); // get the height of the left tree
        int right = helper(root.right, length + 1); // get the height of the right tree

        return Math.max(left, right); // return the max of left and right
    }

    // using BFS
    public static int heightOfBinaryTree(TreeNode root) {
        // Write your code here.
        if(root == null) return 0;
        // solve using BFS

        int length = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size(); // store the size as after adding childrens size is going to change
            // get the top first node
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.right != null) queue.offer(current.right);
                if(current.left != null) queue.offer(current.left);
            }
            length++;
        }

        return length;
    }
}
