package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

import java.util.ArrayList;

public class SegregateOddEvenIndexes extends Leetcode {
    // brute force method will be traversing through LL with two pointers
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // we have to add all the elements into the arrayList
        ArrayList<Integer> list = new ArrayList<>();
        // take two pointers, one for odd and one for even index
        ListNode even = head;
        ListNode odd = head.next;

        // first traverse for even index
        while (even != null && even.next != null){
            list.add(even.val);
            even = even.next.next;
        }
        // if LL size is odd then we might miss the last element, because of the even.next condition
        // so if even is not null then just add that element into the list
        if(even != null){
            list.add(even.val);
        }

        // now traverse for odd indexes
        while (odd != null && odd.next != null){
            list.add(odd.val);
            odd = odd.next.next;
        }
        // add remaining element
        if(odd != null){
            list.add(odd.val);
        }


        // now we have all the elements, just those elements with LL
        int i = 0;
        ListNode temp = head;
        while (temp != null){
            temp.val = list.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }


    // optimal approach will be playing with links by observation
    public ListNode oddEvenListOptimal(ListNode head){
        if(head == null || head.next == null){
            return head;
        }


        // now get two pointers
        ListNode even = head; // this will be the pointer for even index, which starts from 0.
        ListNode odd = head.next; // this will be pointer for odd index, which starts from 1.
        ListNode oddHead = odd; // memoize the odd index head, because we have make this head next for last even node.

        while (odd != null && odd.next != null){ // odd will be always ahead of even, so termination condition will be based on odd index
            even.next = even.next.next; // point current even next node to 2 step ahead;
            even = even.next; // move even to its next node

            odd.next = odd.next.next; // point current odd node to 2 step ahead, which is next odd index
            odd = odd.next; // move odd ahead
        }

        even.next = oddHead; // now connect the last even index to odd head, which we have store first;
        return head;
    }
}
