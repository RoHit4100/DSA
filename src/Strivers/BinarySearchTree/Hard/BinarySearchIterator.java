package Strivers.BinarySearchTree.Hard;

import Strivers.BinarySearchTree.Leetcode;
import java.util.Stack;
public class BinarySearchIterator extends Leetcode {
    class BSTIterator {
        // to solve this question we will use the stack
        Stack<TreeNode> stack = new Stack<>(); // initialize the stack to store the inorder, with the space complexity of the height of the tree
        public BSTIterator(TreeNode root) {
            pushAll(root); // push all the left elements from the root
        }

        private void pushAll(TreeNode node){ // this function takes a node and push all the lefts
            while(node != null){ // run this loop till we reach null
                stack.push(node); // push the node
                node = node.left; // move to the left
            }
        }

        public int next() { // this function will return the next inorder
            TreeNode node = stack.pop(); // get the top most element of the stack
            pushAll(node.right); // check if top has any right or not, if yes then push all the right nodes into the stack
            return node.val; // return the top nodes val
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        } // return if stack is empty or not
    }
}
