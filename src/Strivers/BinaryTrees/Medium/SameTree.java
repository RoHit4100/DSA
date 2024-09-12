package Strivers.BinaryTrees.Medium;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class SameTree extends CodingNinjas {
    // optimal solution using 4-5 lines
    public boolean isSameTreeOptimal(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are identical at this point
        if (p == null && q == null) return true;

        // If one node is null and the other is not, the trees are different
        if (p == null || q == null) return false;

        // If the values of the nodes are different, the trees are different
        if (p.data != q.data) return false;

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // brute force solution, using preorder traversal
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        preOrder(p, first);
        preOrder(q, second);

        if (first.size() != second.size()) return false;

        // Compare both lists while handling null values
        for (int i = 0; i < first.size(); i++) {
            Integer val1 = first.get(i);
            Integer val2 = second.get(i);

            if (val1 == null && val2 != null) return false;
            if (val1 != null && val2 == null) return false;
            if (val1 != null && !val1.equals(val2)) return false;
        }
        return true;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null); // Add null to the list when the node is null
            return;
        }

        list.add(root.data); // Add the current node's value
        preOrder(root.left, list); // Traverse the left subtree
        preOrder(root.right, list); // Traverse the right subtree
    }
}
