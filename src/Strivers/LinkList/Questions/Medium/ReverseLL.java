package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.Stack;

public class ReverseLL extends CodingNinja {
    // brute force approach will be using Stack
    public static Node reverseLinkedListBF(Node head){
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }
        Stack<Integer> stack = new Stack<>();

        // now first insert all the elements into the stack
        Node temp = head;
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        // now traverse from head again and replace all the values
        temp = head;
        while (temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    // optimal approach will be using 3 pointers
    public static Node reverseLinkedListOptimal(Node head){
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        // now get the tree pointers
        Node current = head;
        Node next = current.next;
        Node prev = null;

        while (current != null){
            // now replace this links
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }


    public static Node reverseLinkedListOptimal2(Node head){
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        // now get the tree pointers
        Node current = head;
        Node prev = null;
        while (current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


    // now using recursion
    public static Node reverseLinkedList(Node head){
        // Write your code here.
        // this will be the base condition for recursion
        if(head == null || head.next == null){
            return head;
        }

        // this line will get the last node of the LL
        Node newHead = reverseLinkedList(head.next);

        // now we are at the second last node;
        // this line will store the next node of the current node;
        Node next = head.next;
        // now we have to assign the current node as the next for his next
        next.next = head;

        // now the link between current node and its next node is broken with below line, and new link is generated
        head.next = null;
        return newHead;
    }
}
