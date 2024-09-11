package Strivers.BinaryTrees.Easy.TraversalsUsingIteration;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class InOrder extends CodingNinjas {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        // to solve this using iteration we'll require stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){ // this loop until stack is empty
            if(node != null){
                stack.push(node); // if node is not null then insert that node into the stack
                node = node.left; // go to the left
            }else{ // if node is left then this condition will run
                // check if stack is empty or not
                if(stack.isEmpty()){
                    break; // break if stack is empty
                }
                // print the top of the stack and go to the right
                TreeNode top = stack.pop(); // get the top of the stack
                ans.add(top.data); // add that top value into the ans

                // go to right of top of node of the stack
                node = top.right;
            }
        }

        return ans;
    }
}
