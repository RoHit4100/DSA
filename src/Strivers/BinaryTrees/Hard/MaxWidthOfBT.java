package Strivers.BinaryTrees.Hard;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT extends CodingNinjas {
    public int widthOfBinaryTree(TreeNode root) {
        // to solve this question we will use the level order traversal which is bfs
        if(root.left == null && root.right == null) return 1;

        // now use the dfs to solve this question
        Queue<Pair> queue = new LinkedList<>(); // this queue will store the pair of the node and its respective index
        queue.offer(new Pair(root, 0)); // insert the root and 0 as its index into the queue
        int width = Integer.MIN_VALUE; // to return the maxWidth

        while(!queue.isEmpty()){  // run this loop until there is no pair or node to check
            int size = queue.size(); // get the size of the current queue
            int leftMost = 0, rightMost = 0; // take the pointers to get the rightMost and leftMost nodes index
            int min = queue.peek().index; // this will be used to prevent the overflow
            for(int i = 0; i < size; i++){ // run this loop till the size
                Pair pair = queue.poll(); // ge the first pair of the queue
                TreeNode current = pair.node; // get the node
                int current_ind = pair.index; // get the index assign to that node

                if(i == 0){ // check if this is the first node or not
                    leftMost = current_ind; // if yes then update the leftMost
                }
                if(i == size - 1){ // check if the current traversing index is last or not
                    rightMost = current_ind; // if yes then make that node's index as rightMost index
                }
                // now reduce the index by min
                current_ind -= min; // decrease the current index by min

                if(current.left != null) {
                    queue.offer(new Pair(current.left, 2 * current_ind + 1)); // INSERT THE LEFT NODE WITH ITS INDEX
                }
                if(current.right != null){
                    queue.offer(new Pair(current.right, 2 * current_ind + 2)); // INSERT THE RIGHT NODE WITH ITS INDEX
                }
            }
            width = Math.max(width, rightMost - leftMost + 1); // update the width
        }
        // return the width
        return width;
    }

    private class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
}
