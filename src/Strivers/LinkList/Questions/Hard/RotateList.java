package Strivers.LinkList.Questions.Hard;

import Strivers.LinkList.Leetcode;

public class RotateList extends Leetcode {
    // this will be the optimal solution
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // now get the last node of the list and the length of the LL
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // make the last node's next as head.
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
        return head;
    }

}
