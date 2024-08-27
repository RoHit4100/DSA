package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;


public class RemoveMiddleNode extends Leetcode {
    // there will be 2 solutions
    public ListNode deleteMiddle(ListNode head) {
        // this solved by me
        if(head == null || head.next == null){
            return null;
        }

        // find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at the middle
        // check slow.next is null or not
        System.out.println(slow.val);
        if(slow.next == null){
            head.next = null;
        }else{
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }

        return head;
    }


    // In second solution we can just use pointers but, here we will start fast pointer from the 2 location ahead, and slow from the start of the LL
    public ListNode deleteMid(ListNode head){
        if(head == null || head.next == null){
            return null;
        }

        // take two pointers
        ListNode fast = head.next.next; // this wil make sure we will reach one node before the middle node
        ListNode slow = head; // now we will start from the head

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // now we are one node before the middle
        slow.next = slow.next.next; // if there are only 2 elements then slow will be present at the head
        return head;
    }
}
