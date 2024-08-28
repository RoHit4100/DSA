package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteDuplicates extends Leetcode {
    // this is the optimal solution
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        ListNode first = head;


        // first check if first is null or not
        while(first != null){
            // first check if their exist next nod or not
            if(first.next != null && first.val == first.next.val){
                // skip all the same nodes
                while(first.next != null && first.val == first.next.val){
                    first = first.next;
                }

                // now move to next node, because current node is same as previous node
                first = first.next;
            }else{
                // if not equal to next element then add the first node to new node
                current.next = first;
                first = first.next;
                current = current.next;
            }

        }

        // disconnect last node from potential similar nodes
        current.next = null;
        return dummyHead.next;
    }

    // better solution will be using HashMap
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Create a HashMap to store the frequency of each node value
        Map<Integer, Integer> map = new HashMap<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            map.put(currentNode.val, map.getOrDefault(currentNode.val, 0) + 1);
            currentNode = currentNode.next;
        }

        // Create a dummy head to help build the result list
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        // Traverse the original list again to construct the new list
        currentNode = head;
        while (currentNode != null) {
            if (map.get(currentNode.val) == 1) {
                current.next = new ListNode(currentNode.val);
                current = current.next; // Advance the current pointer
            }
            currentNode = currentNode.next;
        }

        return dummyHead.next;
    }
}
