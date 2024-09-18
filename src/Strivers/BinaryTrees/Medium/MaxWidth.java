package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth extends CodingNinjas {
    public static int getMaxWidth(TreeNode root) {
        // Write your code here.
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int width = 0;
        // now traverse till the queue gets empty, means no nodes are their to traverse
        while(!queue.isEmpty()){
            int count = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                count++;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            width = Math.max(count, width);
        }
        return width;
    }

}
