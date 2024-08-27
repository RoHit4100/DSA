package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.HashMap;
import java.util.Map;

public class StartingPointOfCycle extends CodingNinja {
    // brute force approach will be using the HashMap
    public static Node getFirstNodeOfCycle(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Map<Node, Integer> map = new HashMap<>();

        while (head != null){
            if(map.containsKey(head)){
                return head;
            }
            map.put(head, 1);
            head = head.next;
        }

        return null;
    }


    // optimal approach will be using fast and slow pointer method
    static Node firstNodeOfCycle(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){ // this means we have found the cycle
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
