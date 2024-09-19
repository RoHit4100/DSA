package Strivers.BinarySearchTree.Easy;

public class FloorInBST {
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
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        while(root != null){
            if(root.data == x){
                return root.data;
            }

            if(root.data > x){
                root = root.left;
            }else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
