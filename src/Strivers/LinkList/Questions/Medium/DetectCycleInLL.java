package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.HashMap;
import java.util.HashSet;

public class DetectCycleInLL extends CodingNinja {
    // brute force approach will use the HashMap to store each node
    public static boolean detectCycleBF(Node head){
        if(head == null || head.next == null){
            return false;
        }


        // create a HashMap
        HashMap<Node, Integer> map = new HashMap<>();

        while (head != null){
            if(map.containsKey(head)){
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }

        return false;
    }



    // this is the optimal approach to detect a loop in LL
    public static boolean detectCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }


        // now we will first use the fast and slow pointer method or tortoise method
        Node slow = head;
        Node fast = head;


        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }



    // detect cycle using recursion
    public boolean hasCycle(Node head) {
        if(head == null || head.next == null){
            return false;
        }

        return helper(head.next, head.next.next);
    }

    private boolean helper(Node slow, Node fast){
        if(fast == null || fast.next == null){
            return false;
        }
        if(slow == fast){
            return true;
        }

        return helper(slow.next, fast.next.next);
    }
}
