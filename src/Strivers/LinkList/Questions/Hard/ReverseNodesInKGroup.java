package Strivers.LinkList.Questions.Hard;

import Strivers.LinkList.Leetcode;

import java.util.List;

public class ReverseNodesInKGroup extends Leetcode {
    // kunal's method
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }


        // now traverse till current reaches to end
        ListNode current = head;
        ListNode prev = null;

        // get the length
        int length = getLength(head);
        // find how many groups we have to reverse
        int count = length / k;

        // now run this loop till count reaches to 0
        while(count > 0){
            // get the last node
            ListNode last = prev;
            ListNode newEnd = current;

            // now reverse the group
            ListNode next = current.next;
            for(int i = 0; current != null && i < k; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            // check if last is null or not, if null then that means
            // prev, which is head of reverse LL, will be new head
            if(last != null){
                last.next = prev; // which will be previous newEnd
            }else{
                head = prev; // update head as reverseHead
            }

            newEnd.next = current;
            prev = newEnd;
            count--;
        }

        return head;
    }

    private int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }


    // strivers method

    class Node {
        // Data stored in the node
        int data;
        // Pointer to the next
        // node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        // Function to get the Kth node from
        // a given position in the linked list
    static Node getKthNode(Node temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;

        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            // Move to the next node
            temp = temp.next;
        }
        // Return the Kth node
        return temp;
    }

    // Function to reverse nodes in groups of K
    static Node kReverse(Node head, int k) {
        if(head == null || k <= 1 || head.next == null){
            return head;
        }
        // Initialize a temporary
        // node to traverse the list
        Node temp = head;

        // Initialize a pointer to track the
        // last node of the previous group
        Node prevLast = null;

        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);
                // If the Kth node is NULL
                // (not a complete group)
                if (kThNode == null) {
                    // If there was a previous group,
                    // link the last node to the current node
                    if (prevLast != null) {
                        prevLast.next = temp;
                    }
                    // Exit the loop
                    break;
                }

                // Store the next node
                // after the Kth node
                Node nextNode = kThNode.next;

                // Disconnect the Kth node
                // to prepare for reversal
                kThNode.next = null;

                // Reverse the nodes from
                // temp to the Kth node
                reverse(temp);

                // Adjust the head if the reversal
                // starts from the head
                if (temp == head) {
                    head = kThNode;
                } else {
                    // Link the last node of the previous
                    // group to the reversed group
                    prevLast.next = kThNode;
                }

                // Update the pointer to the
            // last node of the previous group
            prevLast = temp; // Move to the next group
            temp = nextNode;
        }

        // Return the head of the
        // modified linked list
        return head;
    }

    private static Node reverse(Node node) {
        Node current = node;
        Node prev = null;
        Node next = current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}
