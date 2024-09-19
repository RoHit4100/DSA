package Strivers.BinarySearchTree.Hard;

import Strivers.BinarySearchTree.Leetcode;
import java.util.Stack;
public class BinarySearchIterator extends Leetcode {
    class BSTIterator {
        // to solve this question we will use the stack
        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        private void pushAll(TreeNode node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAll(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
