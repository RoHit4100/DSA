package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class InsertNodeIntoBST extends Leetcode {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val); // if root is null create new node and return that node
        }


        // now traverse into the tree, while we get right or left node as null
        TreeNode current = root; // take pointer to for traversing
        while(true){
            if(current.val > val){ // check if the current node is greater than the val
                // in this case check if the current left is null or not
                if(current.left != null) current = current.left; // if not null, then move in the left
                else{ // if null, means we can add the given value in this location
                    TreeNode node = new TreeNode(val);
                    current.left = node; // connect into left and break
                    break;
                }
            }else{ // this means current node has the smaller value than the target
                if(current.right != null) current = current.right;
                else{
                    TreeNode node = new TreeNode(val);
                    current.right = node;
                    break;
                }
            }
        }
        // return the root
        return root;
    }
}
