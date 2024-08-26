package Strivers.LinkList.Questions.Easy;

import java.util.Stack;

public class ReverseDLL {
    private class Node {

        public int data;
        public Node next;
        public Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }
    // brute force method uses the stack
    public static Node reverseDLL(Node head){
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        // first in last out
        Node temp = head;
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        // Now my stack has the all elements
        // replace all the elements with stack elements
        while (temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }



    // optimal solution will use the swapping with only one iteration
    // this is using 2 pointers method
    public static Node reverseDLLOptimal(Node head) {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node prev = null;
        while(current != null){
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
    }


    // this is using 3 pointers method
    public static Node reverseDLLOptimal2(Node head)
    {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node prev = null;
        Node next = current.next;

        while(current != null){
            current.next = prev;
            current.prev = next;

            prev = current;
            current = next;

            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
}
