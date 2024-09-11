package Strivers.BinaryTrees.Easy;

import Strivers.BinaryTrees.CodingNinjas;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversals extends CodingNinjas {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();

        // for in Order traversal
        List<Integer> inOrder = new ArrayList<>();
        inOrder(inOrder, root);
        ans.add(inOrder);

        // for pre Order traversal
        List<Integer> preOrder = new ArrayList<>();
        preOrder(preOrder, root);
        ans.add(preOrder);

        // for post Order traversal
        List<Integer> postOrder = new ArrayList<>();
        postOrder(postOrder, root);
        ans.add(postOrder);

        return ans;
    }

    private static void inOrder(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        inOrder(list, root.left);
        list.add(root.data);
        inOrder(list, root.right);
    }

    private static void preOrder(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.data);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    private static void postOrder(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.data);
    }
}
