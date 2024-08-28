package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.CodingNinja;

public class RemoveDuplicates {
    private class Node{
        int data;
        Node next, prev;
        Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }
    // this solution is used for doubly linkList
    Node removeDuplicates(Node head){
        // Code Here.
        if(head == null || head.next == null){
            return head;
        }

        Node first = head;
        Node second = head.next;

        while(second != null){
            if(first.data != second.data){
                first.next = second;
                second.prev = first;
                first = first.next;
            }
            second = second.next;
        }

        first.next = null;
        return head;
    }

}
