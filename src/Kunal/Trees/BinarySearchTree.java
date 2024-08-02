package Kunal.Trees;

import org.w3c.dom.Node;

public class BinarySearchTree {
    private Node root;
    public class Node{
        Node left;
        Node right;
        int height;
        int value;
        Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }
}
