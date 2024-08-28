package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.ArrayList;
import java.util.Collections;

public class SortList extends CodingNinja {
    // brute force will be storing all the elements into a ArrayList and then sorting and, then replacing values of each node
    public static Node sortLL(Node head) {
        // Write your code here.
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;
        // add all the elements into the list
        while (temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        // now sort the list
        Collections.sort(list);

        // now replace the values with sorted list
        int index = 0;
        temp = head;
        while (temp != null){
            temp.data = list.get(index);
            temp = temp.next;
            index++;
        }

        return head;
    }


    // optimal approach will be using merge Sort to sort the LL
    public static Node sortLLOptimal(Node head){
        if (head == null || head.next == null){
            return head;
        }

        return mergeSort(head);
    }

    private static Node mergeSort(Node head){
        // return when there is only one node
        if(head.next == null){
            return head;
        }

        Node mid = getMiddle(head);
        // now get the first node of the first half and first node of the second half
        Node first = head;
        Node second = mid.next;
        mid.next = null; // this will break the LL from the middle;

        Node left = mergeSort(first);
        Node right = mergeSort(second);

        // now return the head of the new merged list
        return merge(left, right);
    }

    private static Node merge(Node head1, Node head2){
        // in this node we will merge the two given nodes
        // create a dummy head to return at the end as head
        Node dummyHead = new Node(0);
        // now store this dummyHead in variable to add nodes into this list
        Node tail = dummyHead;

        // this loop will add all the nodes in sorted manner until one of the LL becomes empty
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // now check if any of the LL has nodes or not
        if (head1 != null){
            tail.next = head1;
        }

        if (head2 != null){
            tail.next = head2;
        }


        // now in the end return the dummy head;
        return dummyHead.next;
    }

    private static Node getMiddle(Node node){
        Node slow = node;
        Node fast = node.next; // to get the first middle in the case of even size of LL

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // this will be the middle
    }
}
