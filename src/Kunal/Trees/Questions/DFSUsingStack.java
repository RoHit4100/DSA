package Kunal.Trees.Questions;

import Kunal.Trees.BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSUsingStack extends BFS {
    public List<Integer> dfsUsingStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            if(currentNode.right != null){
                stack.push(currentNode.right);
            }
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
            list.add(currentNode.val);
        }
        return list;
    }
}
