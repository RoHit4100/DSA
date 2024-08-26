package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.CodingNinja;

public class MiddleOfLL extends CodingNinja {
    // brute force approach will be finding the size of the node and then finding the middle of the LL as well
    public static Node findMiddle(Node head){
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        // now first find the size of the LL
        int size = 0;
        Node node = head;

        while (node != null){
            node = node.next;
            size++;
        }

        // now get the middle
        int mid = size / 2;
        node = head;
        int index = 0;
        while (index != mid){
            node = node.next;
            index++;
        }

        return node;
    }


    // optimal approach will be using slow and fast pointer method which is also known as tortoise method
    public static Node findMiddleOptimal(Node head){
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        // there will be two pointer
        // both pointers will start from the head
        Node slow = head; // this will move by 1 step
        Node fast = head; // this will move by 2 step

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

