package Kunal.Trees.Questions;

import Kunal.Trees.BFS;

public class FindTwoSwappedNodesInBST extends BFS {

    TreeNode first;
    TreeNode second;

    public TreeNode findSwapped(TreeNode root){
        if(root == null){
            return null;
        }

        // now the actual swap part
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return root;
    }

    private void helper(TreeNode node, TreeNode prev){
        if(node == null){
            return;
        }

        // now go to the left end of the tree
        helper(node.left, prev);

        // now first check
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        helper(node.right, prev);
    }
}
