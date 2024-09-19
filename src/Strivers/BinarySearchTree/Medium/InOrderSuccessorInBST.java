package Strivers.BinarySearchTree.Medium;

public class InOrderSuccessorInBST {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public Node inorderSuccessor(Node root,Node x){
        //add code here.
        // optimal solution will be performing bst traversal and finding the first node
        // which is the greater than the x
        Node successor = null;
        while(root != null){
            if(root.data > x.data){
                successor = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return successor;
    }
}
