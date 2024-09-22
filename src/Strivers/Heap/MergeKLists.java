package Strivers.Heap;

import java.util.PriorityQueue;

public class MergeKLists {
      public class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
    public ListNode mergeKLists(ListNode[] lists) {
        // If the input list is empty, return null
        if (lists.length == 0) {
            return null;
        }

        // Priority queue to store the nodes, ordered by their values
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the priority queue
        for (ListNode head : lists) {
            // Only add non-null heads to the heap
            if (head != null) {
                heap.offer(head);
            }
        }

        // Dummy head to simplify the merge process
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead; // Pointer to build the new merged list

        // While the priority queue is not empty
        while (!heap.isEmpty()) {
            // Extract the node with the smallest value
            ListNode node = heap.poll();
            // Append this node to the merged list
            temp.next = node;
            // Move the pointer to the last node in the merged list
            temp = temp.next;

            // If there are more nodes in the current list, add the next node to the heap
            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        // Return the next node of dummyHead, which is the head of the merged list
        return dummyHead.next;
    }

}
