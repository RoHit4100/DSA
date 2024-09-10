package ProblemOfTheDay.LeetCode;

import Strivers.LinkList.Leetcode;

public class InsertGCDInLL extends Leetcode {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // return head, if there is only one node
        if(head.next == null){
            return head;
        }

        // create temp node for traversal
        ListNode temp = head;
        while(temp.next != null){ // traverse till we reach to last node
            int a = temp.val; // get the current node's val
            int b = temp.next.val; // get the next node's val

            // get the gcd
            int gcd = gcd(a, b); // get the gcd
            ListNode node = new ListNode(gcd); // create new Node with gcd
            // insert the node in between
            ListNode l = temp.next; // store the current next
            temp.next = node; // make new created node as next of temp
            node.next = l; // new node's next will be the store next
            temp = l; // move temp to stored next
        }

        return head; // return head
    }

    private int gcd(int a, int b){
        if(a == 0){
            return b; // return if a is 0
        }else if(b == 0){
            return a; // return if b is 0
        }

        if(a > b){
            return gcd(a % b, b); // condition when a is greater
        }else{
            return gcd(a, b % a); // condition when b is greater
        }
    }
}
