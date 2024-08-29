package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.Leetcode;

public class SplitLLIntoKEqualParts extends Leetcode {
    // solved by me.
    public ListNode[] splitListToParts(ListNode head, int k) {
        // First, find the size of the linked list
        int size = getSize(head);

        ListNode[] ans = new ListNode[k];
        int extra = size % k; // Extra nodes that need to be distributed
        int length = size / k; // Minimum number of nodes in each part

        ListNode temp = head;
        int index = 0;

        while (temp != null && index < k) {
            ListNode current = temp;
            ans[index] = current;

            // Determine the length of the current part
            int currentPartSize = length + (extra > 0 ? 1 : 0);

            // Move the pointer to the end of the current part
            for (int i = 1; i < currentPartSize; i++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Move the temp pointer to the next part and disconnect the current part
            if (current != null) {
                temp = current.next;
                current.next = null;
            } else {
                temp = null;
            }

            // Decrease the extra nodes counter if used
            if (extra > 0) {
                extra--;
            }

            index++;
        }

        // If there are more parts than nodes, fill the remaining parts with null
        while (index < k) {
            ans[index] = null;
            index++;
        }

        return ans;
    }

    private int getSize(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
