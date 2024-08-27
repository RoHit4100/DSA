package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.HashMap;
import java.util.Map;

public class LengthOfCycle extends CodingNinja {
    // the brute force solution will be using hashMap and storing the location of each node in the hash map
    // and once that same node is found we can just reduce the current length from the previous occurred length
    static int lengthOfLoop(Node head){
        if(head == null || head.next == null){
            return 0;
        }

        // create a hashMap
        Map<Node, Integer> map = new HashMap<>();

        int timer = 0;
        while (head != null){
            if(map.containsKey(head)){
                int length = timer - map.get(head);
                return length;
            }

            map.put(head, timer);

            head = head.next;
            timer++;
        }

        return 0;
    }


    // this is the optimal approach to find the length of the cycle
    static int getLengthOfCycle(Node head){
        if(head == null){
            return 0;
        }

        // fast and slow pointer method
        Node slow = head;
        Node fast = head;
        int length = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // now count the length of the cycle
                do{
                    length++;
                    slow = slow.next;
                }while (slow != fast);
                break;
            }
        }

        return length;
    }
}
