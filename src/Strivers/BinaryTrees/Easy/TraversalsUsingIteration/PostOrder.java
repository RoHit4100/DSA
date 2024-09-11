package Strivers.BinaryTrees.Easy.TraversalsUsingIteration;
import java.util.*;
public class PostOrder {
    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode() {
            this.data = null;
            this.left = null;
            this.right = null;
        }

        public TreeNode(T x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }

        public TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
            this.data = x;
            this.left = left;
            this.right = right;
        }
    };

    // using two stacks
    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        // Write your code here
        // to solve this question as iterative method we have to use two stacks
        List<Integer> ans = new ArrayList<>(); // create list for returning purpose
        if(root == null) return ans; // return empty list if root is null

        Stack<TreeNode<Integer>> stack = new Stack<>(); // this stack will store the left and right nodes
        Stack<TreeNode<Integer>> postOrder = new Stack<>(); // this stack will store the postOrder traversal
        stack.push(root); // initially insert the root node into stack

        while(!stack.isEmpty()){ // run until stack becomes empty
            // first get the top of the stack
            TreeNode<Integer> top = stack.pop(); // pop the top most node

            postOrder.push(top); // insert into postorder stack
            if(top.left != null) stack.push(top.left); // if left node exist insert into stack
            if(top.right != null) stack.push(top.right); // if right node exist insert into stack
        }

        // pop the element out of postOrder and insert into answer
        while(!postOrder.isEmpty()){ // now insert the answers from the post order traversal
            TreeNode<Integer> popped = postOrder.pop();
            ans.add(popped.data);
        }
        // return answer
        return ans;
    }
}
