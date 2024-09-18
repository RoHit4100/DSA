package Strivers.BinaryTrees.Medium;

public class ChildrenSumInBinaryTree {
    class Node{
        int data;
        Node left,right;

        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    public static int isSumProperty(Node root) {
        // Base case: If the tree is empty, or it's a leaf node, it satisfies the property
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }

        // Initialize left and right child values as 0 if they are null
        int leftChild = (root.left != null) ? root.left.data : 0;
        int rightChild = (root.right != null) ? root.right.data : 0;

        // Check if the current node satisfies the sum property
        if (root.data != leftChild + rightChild) {
            return 0;
        }

        // Recursively check the left and right subtrees
        int leftSide = isSumProperty(root.left);
        int rightSide = isSumProperty(root.right);

        // If both sides satisfy the sum property, return 1, else return 0
        return (leftSide == 1 && rightSide == 1) ? 1 : 0;
    }
}
