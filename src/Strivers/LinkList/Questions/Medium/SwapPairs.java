package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

public class SwapPairs extends Leetcode {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode current = head;

        while(current != null && current.next != null){
            // get the first and second Nodes
            ListNode first = current;
            ListNode second = current.next;

            // now swap the first and second
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // now move the current and prev pointers
            prev = first;
            current = first.next;
        }
        return dummyHead.next;
    }
}
