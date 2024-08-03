package Kunal.Trees;

import java.util.Scanner;

public class CreateTreeAgain {

    Node root;

    public void insert(Scanner sc){
        System.out.println("Enter the root node");
        int value = sc.nextInt();
        Node node = new Node(value);
        root = node;

        // now call the insert function for recursive insertion of the node.
        insert(sc, root);
        display(root);
    }

    void display(Node node){
        System.out.print(node.value);
        display(node, "");
    }
    void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left , indent + "\t\t");
        display(node.right, indent + "\t\t");
    }
    void insert(Scanner sc, Node node){
        System.out.println("Want to insert at the left of " + node.value);
        boolean left = sc.nextBoolean();

        if(left){
            System.out.println("Enter the value that u want to insert in the left of " + node.value);
            int val = sc.nextInt();
            Node leftNode = new Node(val);
            node.left = leftNode;
            insert(sc, leftNode);
        }

        System.out.println("Want to insert at the right of " + node.value);
        boolean right = sc.nextBoolean();

        if(right){
            System.out.println("Enter the value that u want to insert in the right of " + node.value);
            int val = sc.nextInt();
            node.right = new Node(val);
            insert(sc, node.right);
        }
    }

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CreateTreeAgain tree = new CreateTreeAgain();
        tree.insert(new Scanner(System.in));
    }
}
