package Kunal.Trees;

import java.util.Scanner;

public class AVL {
      class Node{
        private int value;
        int height;
        private Node left;
        private Node right;

        Node(int value){
            this.value = value;
        }
    }
    Node root;
    boolean isEmpty(){
        return root == null;
    }

    void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            Node newNode = new Node(value);
            return newNode;
        }

        if(node.value > value){
            node.left = insert(node.left, value);
        }else if (node.value < value){
            node.right = insert(node.right, value);
        }else{
            // to avoid duplications
            return node;
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return rotate(node);
    }

    private Node rotate(Node node){
        // if this condition hits it means the tree is left heavy
        if(getHeight(node.left) - getHeight(node.right) > 1){
            // if tree is left heavy then their will be two cases, first will left-left and another will be left-right
            // it means if the height of left tree and right tree is less than 0 then we will perform right rotate
            if(getHeight(node.left.left) - getHeight(node.left.right) > 0){
                return rightRotate(node);
            }
            if(getHeight(node.left.left) - getHeight(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // if tree is not left heavy then it has to be right heavy
        if(getHeight(node.left) - getHeight(node.right) < -1) {
            if (getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                return leftRotate(node);
            }

            if(getHeight(node.right.left) - getHeight(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node node){
        Node child = node.left;
        Node t = child.right;


        child.right = node;
        node.left = t;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;
        return child;
    }


    private Node leftRotate(Node node){
        Node child = node.right;
        Node t = child.left;

        child.left = node;
        node.right = t;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;
    }
    int getHeight(Node node){
        if(node == null){
            return -1;
        }

        return node.height;

    }

    int getHeight(){
        return getHeight(root);
    }
    public static void main(String[] args) {
        AVL tree = new AVL();

        for(int i = 1; i < 1000; i++){
            tree.insert(i);
        }
        System.out.println(tree.getHeight());
    }
}
