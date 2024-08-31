package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.Leetcode;

public class ConvertLLOfBinaryNumIntoDecimal extends Leetcode {
    public int getDecimalValue(ListNode head) {
        // first reverse the LL
        ListNode node = reverse(head);
        int result = 0;
        int power = 1;
        while(node != null){
            if(node.val == 1){
                result += power;
            }
            power *= 2;
            node = node.next;
        }

        return result;
    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
}
