package Kunal.Hash.Questions;

import Kunal.Trees.BFS;

import java.util.HashSet;

public class FindTargetInBT extends BFS {
    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        HashSet<Integer> map = new HashSet<>();
        return helper(root, k, map);
    }

    private boolean helper(TreeNode node, int k, HashSet<Integer> map){
        if(node == null){
            return false;
        }
        // now check whether the current node - k element present in the map or not
        if(map.contains(k - node.val)){
            return true;
        }
        map.add(node.val);
        return helper(node.left, k, map) || helper(node.right, k, map);
    }
}
