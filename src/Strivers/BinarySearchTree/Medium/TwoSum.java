package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

import java.util.HashSet;

public class TwoSum extends Leetcode {
    // using map to find the two sum
    public boolean findTarget(TreeNode root, int k) {
        if(root.left == null && root.right == null) return false;

        HashSet<Integer> set = new HashSet<>(); // define set to search the required value
        return helper(root, set, k);
    }

    private boolean helper(TreeNode root, HashSet<Integer> map, int k){
        if(root == null) return false; // if root is null then return false

        int require = k - root.val; // check the require value
        if(map.contains(require)){ // if map contains the require value then return true
            return true;
        }
        map.add(root.val); // insert the current value into the map
        return helper(root.left, map, k) || helper(root.right, map, k); // call for the right and left tree
    }
}
