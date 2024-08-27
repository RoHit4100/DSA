package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

public class RemoveNthNodeFromLast extends Leetcode {
    // brute force approach will be finm
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        // first get the length of the LL
        int length = getLength(head);

        // now find the node that we have to remove
        int result = length - n;
        if(result == 0){
            return head.next;
        }
        // now traverse int LL till we result becomes zero
        ListNode node = head;
        while (result > 1){
            result--;
            node = node.next;
        }

        // now node is just previous to the node that we want to delete
        ListNode removed = node.next;
        if(removed != null) {
            node.next = removed.next;
        }
        return head;
    }

    private int getLength(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }

        return count;
    }



    // optimal approach will be taking two pointers and moving fast point till n.
    public ListNode removeNthFromEndOptimal(ListNode head, int n){
        if(head == null){
            return null;
        }
        // move fast pointer till n
        ListNode fast = head;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        // this means we have to remove our first node
        // when n == size of the LL this condition will trigger were we have to remove the first node of the LL
        if (fast == null){
            return head.next;
        }
        // now take slow pointer from the head and move both of the pointers till fast reaches to end
        ListNode slow = head;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // now slow will be at nth node
        // therefore point its next to next's next node
        slow.next = slow.next.next;

        return head;
    }
}
