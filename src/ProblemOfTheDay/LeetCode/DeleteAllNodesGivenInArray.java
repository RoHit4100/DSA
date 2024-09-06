package ProblemOfTheDay.LeetCode;

public class DeleteAllNodesGivenInArray {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];

            // Remove target if it's at the head
            while (head != null && head.val == target) {
                head = head.next;
            }

            if (head == null) {
                break;
            }

            ListNode node = head;

            // Traverse the list and remove matching nodes
            while (node.next != null) {
                if (node.next.val == target) {
                    node.next = node.next.next; // Skip the target node
                } else {
                    node = node.next; // Move to the next node only if no deletion
                }
            }
        }

        return head;
    }
}
