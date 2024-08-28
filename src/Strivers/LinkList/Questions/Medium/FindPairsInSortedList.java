package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindPairsInSortedList{
    // in this problem we have to return true if their exists a pair
    // brute force approach will be finding all possible pairs
    public static boolean findPair(Node head, int k) {
        // Write your code here.
        if(head == null || head.next == null){
            return false;
        }

        // now find pairs
        Node first = head;

        while (first.next != null){
            Node second = first.next;
            // find pairs for first
            while (second != null){
                if(first.data + second.data == k){
                    return true;
                }
                second = second.next;
            }
            first = first.next;
        }
        return false;
    }


    // better solution will be using hashing to find the pairs
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        if (head == null || head.next == null) {
            return new ArrayList<>();
        }

        // Create a HashMap to store the node values and their corresponding nodes
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Traverse the linked list
        while (head != null) {
            int required = target - head.data;

            // Check if the complement exists in the map
            if (map.containsKey(required)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(required); // Add the complement value
                list.add(head.data); // Add the current node value
                ans.add(list);
            }

            // Add the current node's value to the map
            map.put(head.data, head);

            // Move to the next node
            head = head.next;
        }
        return ans;
    }

    // optimal solution will be using the fact that list is sorted and given LL is doubly LL
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum1(int target, Node head) {
        // code here
        if (head == null || head.next == null) {
            return new ArrayList<>();
        }

        // Find the tail of the doubly linked list
        Node tail = getTail(head);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Compare elements from head and tail until they meet or cross each other
        while (head != null && tail != null && head != tail && head.prev != tail) {
            int sum = head.data + tail.data;

            if (sum == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(head.data);
                list.add(tail.data);
                ans.add(list);
                head = head.next;
                tail = tail.prev;
            } else if (sum < target) {
                head = head.next;  // Increase sum by moving head forward
            } else {
                tail = tail.prev;  // Decrease sum by moving tail backward
            }
        }

        return ans;
    }

    static Node getTail(Node head){
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    class Node
    {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }
}
