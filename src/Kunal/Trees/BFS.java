package Kunal.Trees;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode next;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }


    // BFS
    List<List<Integer>> getTheLevels(TreeNode root){
        List<List<Integer>> outer = new ArrayList<>();
        if(root == null){
            return outer;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> inner = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                inner.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            outer.add(inner);
        }

        return outer;
    }

}

