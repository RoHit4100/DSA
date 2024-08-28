package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.Leetcode;

public class DeleteAllOccurrences extends Leetcode {

    // brute force will be creating new LL without given value;
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        // create new LL
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (head != null){
            if(head.val != val){
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        // now make last nodes next node as null;
        current.next = null;
        return dummyHead.next;
    }

    // remove from doubly LL
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null){
            return null;
        }

        // if x is present in the start then first skip all those elements by moving head;
        while (head != null && head.data == x){
            head = head.next;
        }
        Node first = head; // this pointer will only move when we find other element than x
        Node second = head.next; // this pointer will only find the element which doesn't have value as x

        while (second != null){
            if(second.data != x){
                first.next = second;
                second.prev = first;
                first = first.next;
            }
            second = second.next;
        }
        first.next = null;
        return head;
    }

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }
}
