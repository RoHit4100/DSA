package Kunal.Trees;

import java.util.Scanner;

public class CreateTree {

    Node root;
    CreateTree(){}

    public void populate(Scanner sc){

        System.out.println("Enter the root node");
        int value = sc.nextInt();
        // here I am taking the value
        // after this I am going to assign this value to the root node of the tree.
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do u want to insert left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value that u want to insert in the left of " + node.value);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do u want to insert in right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value that u want to insert in the right of " + node.value);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right, level + 1);
        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
    private class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreateTree tree = new CreateTree();
        tree.populate(sc);
//        tree.display();
        tree.prettyDisplay();

        /*
output of this code:

Enter the root node
15
Do u want to insert left of 15
true
Enter the value that u want to insert in the left of 15
14
Do u want to insert left of 14
true
Enter the value that u want to insert in the left of 14
13
Do u want to insert left of 13
false
Do u want to insert in right of 13
true
Enter the value that u want to insert in the right of 13
12
Do u want to insert left of 12
false
Do u want to insert in right of 12
false
Do u want to insert in right of 14
true
Enter the value that u want to insert in the right of 14
20
Do u want to insert left of 20
false
Do u want to insert in right of 20
false
Do u want to insert in right of 15
true
Enter the value that u want to insert in the right of 15
50
Do u want to insert left of 50
true
Enter the value that u want to insert in the left of 50
40
Do u want to insert left of 40
false
Do u want to insert in right of 40
false
Do u want to insert in right of 50
true
Enter the value that u want to insert in the right of 50
30
Do u want to insert left of 30
false
Do u want to insert in right of 30
false



|		|------->30
|------->50
|		|------->40
15
|		|------->20
|------->14
|		|		|------->12
|		|------->1


         */
    }

}
