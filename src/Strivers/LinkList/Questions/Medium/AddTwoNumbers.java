package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

import java.util.List;

public class AddTwoNumbers extends Leetcode {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }

        // now get the add both of the node and store that node in new node
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead, first = l1, second = l2;
        int carry = 0;

        while(first != null ||  second != null){
            int n1 = (first != null) ? first.val : 0;
            int n2 = (second != null) ? second.val : 0;
            int result = n1 + n2 + carry;
            temp.next = new ListNode(result % 10);
            carry = result / 10;
            temp = temp.next;
            first = (first != null) ? first.next : null;
            second = (second != null) ? second.next : null;
        }


        if(carry > 0){
            temp.next = new ListNode(1);
        }
        return dummyHead.next;
    }

}
