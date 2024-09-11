package Strivers.BinaryTrees.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTreeLevelOrderTraversal {
    class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    public void createTree(Node root, ArrayList<Integer> v) {
        if (v == null || v.isEmpty()) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // now start from the first index, till v.size()

        int i = 1;
        while(i < v.size() && !queue.isEmpty()){
            Node current = queue.poll();

            // check if there is something to add or not
            if(i < v.size()){
                Node node = new Node(v.get(i));
                current.left = node;
                queue.offer(node);
                i++;
            }

            // now check if there is something present to add in the right or not
            if(i < v.size()){
                Node node = new Node(v.get(i));
                current.right = node;
                queue.offer(node);
                i++;
            }
        }
    }
}
