package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class LCAInBST extends Leetcode {

    // using iterative approach
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        while(root != null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }


    // dfs
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // return null if tree is null

        // check if both of the nodes are smaller than the current root
        if(root.val < p.val && root.val < q.val){ // if both of them are smaller, then search on the right side
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){ // if both of them are greater, then search on the left side
            return lowestCommonAncestor(root.left, p, q);
        }
        return root; // if not is equal to the p or q, or this is the splitting point the return the current node
    }
}
