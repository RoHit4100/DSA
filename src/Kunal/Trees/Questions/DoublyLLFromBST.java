package Kunal.Trees.Questions;

import Kunal.Trees.BFS;

import javax.swing.plaf.basic.BasicFileChooserUI;

public class DoublyLLFromBST extends BFS {
    Node head;
    Node tail;


    public Node convert(TreeNode root){
        helper(root);
        return head;
    }

    private void helper(TreeNode node){
        if(node == null){
            return;
        }


        // first go to end of the tree
        helper(node.left);
        // now first check whether head is null or not
        Node newNode = new Node(node.val);
        if(head == null){
           head = newNode;
        }else {
            // if not then just move tail
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        helper(node.right);

    }
    class Node{
        Node next;
        Node prev;
        int val;

        Node(int value){
            this.val = value;
        }
    }
}
