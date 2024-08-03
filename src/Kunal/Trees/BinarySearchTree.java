package Kunal.Trees;

import org.w3c.dom.Node;

public class BinarySearchTree {

    private Node root;

    int getHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    boolean isEmpty(){
        return root == null;
    }

    void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }

        insert(root,value);
    }

    Node insert(Node node, int value){
        if(node == null){
            // when I am this call, idk to which node I have to connect, that's why a newNode is created and return to
            // the location to connect right or left according to condition.
            Node newNode = new Node(value);
            return newNode;
        }

        if(value < node.value){

            // this line will reconnect with the returned node of this function call
            node.left = insert(node.left, value);
        }else{
            node.right = insert(node.right, value);
        }

        // this line will make sure height is updated for every single node, after update.
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    boolean balance(){
        return balance(root);
    }

    boolean balance(Node node){
        if(node == null){
            return true;
        }

        /* here we are checking whether height of right node and left node is less than or equal to 1 or not. */
        boolean isLessThan1 = Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
        // and this line will take care of all the left and right recursive calls, and at any moment,
        // one of the condition is false then tree isn't balance
        return isLessThan1 && balance(node.left) && balance(node.right);
    }

    void display(){
        display(root, " Root node: ");
    }

    void display(Node node, String info){
        if(node == null){
            return;
        }

        System.out.println(node.value + info);
        display(node.left, " Left node of " + node.value + " is: ");
        display(node.right, " Right node of " + node.value + " is: ");
    }

    public class Node{
        private Node left;
        private Node right;
        private int height;
        private int value;
        Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {34,523,56,456,63,43,224,23, 1, 2, 3};
        for(int i = 0; i < arr.length; i++){
            bst.insert(arr[i]);
        }
        bst.display();
        System.out.println(bst.balance());
    }
}
