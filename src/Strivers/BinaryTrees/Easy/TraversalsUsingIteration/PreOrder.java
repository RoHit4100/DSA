package Strivers.BinaryTrees.Easy.TraversalsUsingIteration;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder extends CodingNinjas {
    public List<Integer> preorderTraversal(TreeNode root) {
        // solve this question using iteration
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        // for iterative approach we'll require the stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // push the root node into the stack

        // now traverse the stack is its empty
        while (!stack.isEmpty()){
            TreeNode current = stack.pop(); // this will give the top most node of the stack
            ans.add(current.data); // this will add the current node's value into the ans list
            // for this traversal insert first right node and then left node
            if(current.right != null){
                stack.push(current.right);
            }

            // check if left is exist or not
            if(current.left != null){
                stack.push(current.left);
            }
        }
        return ans;
    }
}
