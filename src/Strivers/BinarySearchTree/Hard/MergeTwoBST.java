package Strivers.BinarySearchTree.Hard;
import java.util.*;
public class MergeTwoBST {
    class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }



    // optimal solution will be using BST iterator
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // push the left elements of the first tree
        pushAll(root1, stack1);
        // now push the left half of the second tree
        pushAll(root2, stack2);

        // now perform the checks while any of the stack is empty
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            Node first = stack1.peek(); // get the top of the stack1
            Node second = stack2.peek(); // get the top of the stack2
            if(first.data <= second.data){ // check if the first is smaller or second is smaller
                ans.add(first.data); // if first is smaller, then add that item into the answer
                Node node = stack1.pop();  // pop the top node from the stack
                pushAll(node.right, stack1); // push all the left nodes of the node.right
            }else{ // if second is smaller, then do the same for the second tree
                ans.add(second.data);
                Node node = stack2.pop();
                pushAll(node.right, stack2);
            }
        }

        // in the end add all the elements from the stack which is not empty yet, and keep cautious about, one of the tree
        // can have the elements
        while(!stack1.isEmpty()){
            Node node = stack1.pop(); // add the elements without checking
            ans.add(node.data);
            pushAll(node.right, stack1); // push the right half of the node
        }

        while(!stack2.isEmpty()){
            Node node = stack2.pop();
            ans.add(node.data);
            pushAll(node.right, stack2);
        }
        // return ans
        return ans;
    }

    private void pushAll(Node node, Stack<Node> stack){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    class Solution {
        // Function to return a list of integers denoting the node
        // values of both the BST in a sorted order.
        // brute force solution will be adding every item's into the list and then sorting the list
        public List<Integer> merge(Node root1, Node root2) {
            // Write your code here
            List<Integer> ans = new ArrayList<>();
            inorder(root1, ans);
            inorder(root2, ans);
            Collections.sort(ans);
            return ans;
        }

        private void inorder(Node root, List<Integer> list){
            if(root == null) return;

            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }
}
