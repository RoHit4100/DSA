package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.ArrayList;

public class PathToNode extends CodingNinjas {
    public ArrayList<Integer> solve(TreeNode root, int target) {
        ArrayList<Integer> ans = new ArrayList<>(); // create list for returning purpose
        if(root == null) return ans; // return empty if root is null

        findPath(root, target, ans); // call the function to find the path
        return ans;
    }

    private boolean findPath(TreeNode root, int target, ArrayList<Integer> ans){
        if(root == null) return false; // return false if we are at the end

        ans.add(root.data); // add the current node into ans

        if(root.data == target) { // check if the current node is target or not, if target then return true, there is no need to search further
            return true;
        }
        // call left and right functions, check if any of them true or not
        boolean left = findPath(root.left, target, ans);
        boolean right = findPath(root.right, target, ans);
        if(!left && !right) { // if both of them are false, it means we haven't found target yet,
            ans.remove(ans.size() - 1); // then remove from the ans, and return false, for above calls
            return false;
        }
        // if any of them is true that means we have found the answer, and return true from here
        return true;
    }
}
