package Strivers.BinaryTrees.Easy;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends CodingNinjas {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        // for level order traversal, we have to perfrom bfs, breadth first search
        // for that we need queue, first in first out data structure to store the nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            // get the size of the queue,
            List<Integer> list = new ArrayList<>();
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                // pop the first element of the queue
                TreeNode current = queue.poll();
                assert current != null;
                list.add(current.data); // add the current nodes.value into the level list
                // check if current node has the left or not
                if(current.left != null){
                    queue.offer(current.left);
                }

                // check if the current node has right child or not
                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            // in the end add the level list into the ans list
            ans.add(list);
        }

        // return the answer
        return ans;
    }
}
