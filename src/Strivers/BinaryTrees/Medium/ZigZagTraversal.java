package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class ZigZagTraversal extends CodingNinjas {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        // to solve this question we will use deque
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);

        // take a flag to keep track of traversal
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                // first get the current node
                if(leftToRight){ // this will be triggered to perform left to right traversal
                    // normal order
                    TreeNode current = queue.pollFirst();
                    list.add(current.data);
                    // now insert normally in the queue
                    // for left
                    if(current.left != null) queue.offerLast(current.left);

                    // for right
                    if(current.right != null) queue.offerLast(current.right);
                }else{ // this will trigger for right to left traversal
                    // reverse order
                    // now get the element from the end of the queue
                    TreeNode current = queue.pollLast();
                    list.add(current.data);

                    if(current.right != null) queue.offerFirst(current.right);
                    if(current.left != null) queue.offerFirst(current.left);
                }
            }

            leftToRight = !leftToRight;
            ans.add(list);
        }

        return ans;
    }
}
