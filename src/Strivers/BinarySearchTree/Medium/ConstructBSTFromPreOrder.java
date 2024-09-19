package Strivers.BinarySearchTree.Medium;

import Strivers.BinarySearchTree.Leetcode;

public class ConstructBSTFromPreOrder extends Leetcode {
    public TreeNode bstFromPreorder(int[] preorder) {
        // brute force will be checking from the start of the tree
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private void insert(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                if (root.left != null) root = root.left;
                else {
                    TreeNode node = new TreeNode(val);
                    root.left = node;
                    break;
                }
            } else {
                if (root.right != null) root = root.right;
                else {
                    TreeNode node = new TreeNode(val);
                    root.right = node;
                    break;
                }
            }
        }
    }
}
