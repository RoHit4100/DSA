package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.Leetcode;

import java.util.HashSet;
import java.util.List;

public class IntersectionPointOfLL extends Leetcode {
    // brute force approach will be using hashset to store the nodes
    public ListNode getIntersectionNodeBF(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        // now first traverse through first LL, and then traverse through second LL
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode temp = headA;
        
        // store all the node into the hashset
        while (temp != null){
            set.add(temp);
            temp = temp.next;
        }
        // now traverse through next LL
        temp = headB;

        while (temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    // second approach will be finding the length of the both of the list and then just finding the difference between
    // those 2 list, and then moving the longer list till the result
    // and then checking if both of the nodes are meet at any point or not
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int n1 = getSize(headA);
        int n2 = getSize(headB);

        // now we have found the size, find the starting point to check further
        int startingPoint = 0;
        // in this case we have to move second lists head till starting point reaches to zero
        if(n2 > n1){
            startingPoint = n2 - n1;
            return findIntersection(headB, headA, startingPoint);
        }
        startingPoint = n1 - n2;
        return findIntersection(headA, headB, startingPoint);
    }

    // this method will find the intersection if exist or else just return the null;
    public ListNode findIntersection(ListNode first, ListNode second, int n){
        while(n > 0){
            first = first.next;
            n--;
        }

        while (first != second){
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public int getSize(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }


    // another approach will be based on some observation
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        // int this solution we will take headA and headB by one step, till any of them reaches to null, or end
        // if any one of the node reaches to end, then move that to second nodes head, and vise versa until they both point to the same node
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }
}
