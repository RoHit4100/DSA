package Strivers.BinaryTrees.Medium;

import java.util.ArrayList;

public class LeftView {
    class Node{
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> leftView(Node root){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        printLeft(root, 0, ans);
        return ans;
    }

    private void printLeft(Node root, int level, ArrayList<Integer> list){
        if(root == null) return;

        if(level == list.size()){
            list.add(root.data);
        }
        // go to the extreme left
        printLeft(root.left, level + 1, list);
        printLeft(root.right, level + 1, list);
    }
}
