package Strivers.BinaryTrees.Medium;
import Strivers.BinaryTrees.CodingNinjas;

import java.util.*;
public class RightView extends CodingNinjas {
    // optimal solution will use the dfs approach
    public List<Integer> rightSideViewOptimal(TreeNode root) {
        // now using dfs approach
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        getRightSide(root, 0, ans);
        return ans;
    }

    private void getRightSide(TreeNode root, int level, List<Integer> list){
        if(root == null) return;
        // check if the size of the list is the level, it will make sure that only right view will be inserted
        if(list.size() == level){
            list.add(root.data);
        }
        getRightSide(root.right, level + 1, list); // first go to extreme right of the tree
        getRightSide(root.left, level + 1, list); // then go to extreme left of the tree
    }

    // these will be the brute force solution
    public List<Integer> rightSideView(TreeNode root) {
        // lets use bfs to solve this questions
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(i == 0) ans.add(current.data);

                // insert first right side of node
                if(current.right != null) queue.offer(current.right);
                // then insert left side of the node
                if(current.left != null) queue.offer(current.left);
            }
        }

        return ans;
    }
}
