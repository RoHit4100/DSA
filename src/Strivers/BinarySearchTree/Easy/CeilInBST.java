package Strivers.BinarySearchTree.Easy;

public class CeilInBST {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int ceil = -1;
        while(root != null) { // traverse till the height of the tree
            if(root.data == key) return root.data; // return if the current nodes value is the key
            if(root.data > key){ // check if the current node has the greater value than the key,
                ceil = root.data; // if yes then set the ceil as the current nodes value
                root = root.left; // move to the left to find the smallest greater value than the key
            }else{
                root = root.right; // if current node has the smaller value then move to the right to increase the value
            }
        }
        return ceil; // at the end return the ceil
    }
}
